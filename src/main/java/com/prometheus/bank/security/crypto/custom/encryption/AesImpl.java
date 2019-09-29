package com.prometheus.bank.security.crypto.custom.encryption;

import java.util.HashMap;
import java.util.Map;

public class AesImpl {

    public static final int reductionPolynomial = 0b100011011;



    public byte[] encrypt(byte[] message, byte[] key) {

        int keySizeBits = key.length*8;

        int rounds;
        if(keySizeBits == 128) rounds = 10;
        else if (keySizeBits == 192) rounds = 12;
        else if(keySizeBits == 256)rounds = 14;
        else throw new RuntimeException("UnsupportedKeySizeException");

        byte[][] state = new byte[4][4];

        byte[] bytes = message;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                state[j][i] = bytes[4*i+j];
            }
        }

        byte[][] keyExpansion = keyExpansion(key);

        state = addRoundKey(state, getRoundKey(keyExpansion,0));

        for(int r = 1; r <= rounds; r++) {
            byte[][] roundKey = getRoundKey(keyExpansion,r);

            state = subBytes(state, false);
            state = shiftRows(state, false);
            if(r < rounds) state = mixColumns(state, false);
            state = addRoundKey(state, roundKey);
        }

        byte[] resultBytes = new byte[16];

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                resultBytes[4*i+j] = state[j][i];
            }
        }

        return resultBytes;
    }

    public byte[] decrypt(byte[] message, byte[] key) {

        int keySizeBits = key.length*8;

        int rounds;
        if(keySizeBits == 128) rounds = 10;
        else if (keySizeBits == 192) rounds = 12;
        else if(keySizeBits == 256)rounds = 14;
        else throw new RuntimeException("UnsupportedKeySizeException");

        byte[][] state = new byte[4][4];

        byte[] bytes = message;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                state[j][i] = bytes[4*i+j];
            }
        }

        byte[][] keyExpansion = keyExpansion(key);

        state = addRoundKey(state, getRoundKey(keyExpansion,0));

        for(int r = 1; r <= rounds; r++) {
            byte[][] roundKey = getRoundKey(keyExpansion,r);

            state = subBytes(state, true);
            state = shiftRows(state, true);
            if(r < rounds) state = mixColumns(state, true);
            state = addRoundKey(state, roundKey);
        }

        byte[] resultBytes = new byte[16];

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                resultBytes[4*i+j] = state[j][i];
            }
        }

        return resultBytes;
    }

    public byte[][] getRoundKey(byte[][] keyExpansion, int round) {

        byte[][] roundKey = new byte[4][4];

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                roundKey[i][j] = keyExpansion[4*round+j][i];
            }
        }

        return roundKey;
    }

    public byte[][] subBytes(byte[][] state, boolean inverse) {

        byte[][] result = new byte[4][4];

        for(int i = 0; i < state.length; i++) {
            for(int j = 0; j < state[0].length; j++) {
                result[i][j] = applySBox(state[i][j], inverse);
            }
        }

        return result;
    }

    //Left shift
    public byte[][] shiftRows(byte[][] state, boolean inverse) {

        byte[][] shiftedState = new byte[4][4];

        for(int i = 0; i < state.length; i++) {
            byte[] row = state[i];
            byte[] shiftedRow = new byte[4];

            for(int j = 0; j < row.length; j++) {
                if(inverse) shiftedRow[j] = row[(4+j-i)%4];
                else shiftedRow[j] = row[(j+i)%4];
            }

            shiftedState[i] = shiftedRow;
        }

        return shiftedState;
    }

    public byte[][] mixColumns(byte[][] state, boolean inverse) {

        byte[][] multiplier = null;

        if(inverse) {
            multiplier = new byte[][]{
                    {0x0e,0x0b,0x0d,0x09},
                    {0x09,0x0e,0x0b,0x0d},
                    {0x0d,0x09,0x0e,0x0b},
                    {0x0b,0x0d,0x09,0x0e}
            };
        } else {
            multiplier = new byte[][]{
                    {0x02,0x03,0x01,0x01},
                    {0x01,0x02,0x03,0x01},
                    {0x01,0x01,0x02,0x03},
                    {0x03,0x01,0x01,0x02}
            };
        }


        byte[][] resultState = new byte[4][4];

        for(int i = 0; i < 4; i++) {
            byte[][] column = {{state[0][i]}, {state[1][i]}, {state[2][i]}, {state[3][i]}};
            byte[][] product = multiplyMatricesFiniteField(multiplier, column);

            for(int j = 0; j < 4; j++) {
                resultState[j][i] = product[j][0];
            }

        }

        return resultState;
    }

    public byte[][] multiplyMatricesFiniteField(byte[][] m1, byte[][] m2) {

        byte[][] result = new byte[m1.length][m2[0].length];

        int rows = m1.length;
        int cols = m2[0].length;

        for(int i = 0; i < rows; i++) {
            int sum = 0;
            for(int j = 0; j < cols; j++) {
                for(int k = 0; k < 4; k++) {
                    sum ^= multiplyPolynomialsMod(m1[i][k],m2[k][j], reductionPolynomial);
                }
                result[i][j] = (byte)sum;
            }
        }

        return result;
    }

    public int polynomialMod(int poly, int modParam) {

        int a = poly;
        int mod = modParam;

        while (Integer.toBinaryString(a).length() >= Integer.toBinaryString(mod).length()) {

            String bin1 = Integer.toBinaryString(a);
            String binMod = Integer.toBinaryString(mod);
            String binModNew = Integer.toBinaryString(mod << (bin1.length() - binMod.length()));

            //System.out.println(bin1);
            //System.out.println("mod = " + binModNew);

            int newMod = Integer.parseInt(binModNew, 2);
            a ^= newMod;

            //System.out.println("a = " + Integer.toBinaryString(a));
        }

        return a;

    }

    public int multiplyPolynomials(byte b1, byte b2) {
        int product = 0;
        int b11 = Byte.toUnsignedInt(b1);
        int b22 = Byte.toUnsignedInt(b2);
        for(int i = 0; i < 8; i++) {
            if(((b22 >> i) & 1) == 1) {
                product ^= (b11 << i);

            }
        }

        return product;
    }

    public int multiplyPolynomialsMod(byte b1, byte b2, int mod) {
        int product = multiplyPolynomials(b1,b2);
        int quotient = polynomialMod(product, mod);

        return quotient;
    }

    public byte[][] addRoundKey(byte[][] state, byte[][] roundKey) {

        byte[][] result = new byte[4][4];

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                result[i][j] = (byte)(state[i][j] ^ roundKey[i][j]);
            }
        }

        return result;
    }

    public byte[][] keyExpansion(byte[] key) {

        int keySizeBits = key.length*8;

        //Define N as the length of the key in 32-bit words:
        //4 words for AES-128, 6 words for AES-192, and 8 words for AES-256
        int N = 0;
        if(keySizeBits == 128) N = 4;
        else if (keySizeBits == 192) N = 6;
        else if(keySizeBits == 256)N = 8;
        else throw new RuntimeException("UnsupportedKeySizeException");

        //Define K_0, K_1, ... K_(N-1) as the 32-bit words of the original key
        byte[][] K = new byte[N][4];
        byte[] keyBytes = key;
        for(int i = 0; i < N; i++) {
            byte[] subBytes = new byte[]{keyBytes[4*i], keyBytes[4*i+1], keyBytes[4*i+2], keyBytes[4*i+3]};
            K[i] = subBytes;
        }

        //Define W_0, W_1, ... W_(4R-1) as the 32-bit words of the expanded key
        int R = 0;
        if(keySizeBits == 128) R = 11;
        else if (keySizeBits == 192) R = 13;
        else if(keySizeBits == 256)R = 15;
        else throw new RuntimeException("UnsupportedKeySizeException");
        byte[][] W = new byte[4*R][4];

        for(int i = 0; i < 4*R; i++) {
            if(i < N)
                W[i] = K[i];
            else if(i >= N && i%N == 0)
                W[i] = applyXor(applyXor(W[i-N],subWord(rotWord(W[i-1]),false)),
                        new byte[]{(byte)rConst(i/N), 0, 0, 0});
            else if(i >= N && N > 6 && i%4 == 0)
                W[i] = applyXor(W[i-N], rotWord(W[i-1]));
            else W[i] = applyXor(W[i-N], W[i-1]);

            /*
            StringBuilder builder = new StringBuilder();
            builder.append("W["+i+"]=");
            builder.append(Integer.toHexString(W[i][0])+" ");
            builder.append(Integer.toHexString(W[i][1])+" ");
            builder.append(Integer.toHexString(W[i][2])+" ");
            builder.append(Integer.toHexString(W[i][3])+" ");

            System.out.println(new String(builder));
            */

        }

        return W;
    }

    public byte[] applyXor(byte[] arr1, byte[] arr2) {

        int len = arr1.length;
        byte[] result = new byte[len];

        for(int i = 0; i < len; i++) {
            result[i] = (byte)(arr1[i] ^ arr2[i]);
        }

        return result;
    }

    public byte[] rotWord(byte[] word) {

        byte[] rotated = new byte[word.length];

        for(int i = 0; i < word.length; i++) {
            rotated[i] = word[(i+1)%word.length];
        }

        return rotated;
    }

    public byte[] subWord(byte[] word, boolean inverse) {

        byte[] subWord = new byte[word.length];

        for(int i = 0; i < subWord.length; i++) {
            subWord[i] = applySBox(word[i], inverse);
        }

        return subWord;
    }

    public byte applySBox(byte b, boolean inverse) {

        int[][] sBox = null;

        if(inverse) {
            sBox = new int[][]{
                    {0x52, 0x09, 0x6a, 0xd5, 0x30, 0x36, 0xa5, 0x38, 0xbf, 0x40, 0xa3, 0x9e, 0x81, 0xf3, 0xd7, 0xfb},
                    {0x7c, 0xe3, 0x39, 0x82, 0x9b, 0x2f, 0xff, 0x87, 0x34, 0x8e, 0x43, 0x44, 0xc4, 0xde, 0xe9, 0xcb},
                    {0x54, 0x7b, 0x94, 0x32, 0xa6, 0xc2, 0x23, 0x3d, 0xee, 0x4c, 0x95, 0x0b, 0x42, 0xfa, 0xc3, 0x4e},
                    {0x08, 0x2e, 0xa1, 0x66, 0x28, 0xd9, 0x24, 0xb2, 0x76, 0x5b, 0xa2, 0x49, 0x6d, 0x8b, 0xd1, 0x25},
                    {0x72, 0xf8, 0xf6, 0x64, 0x86, 0x68, 0x98, 0x16, 0xd4, 0xa4, 0x5c, 0xcc, 0x5d, 0x65, 0xb6, 0x92},
                    {0x6c, 0x70, 0x48, 0x50, 0xfd, 0xed, 0xb9, 0xda, 0x5e, 0x15, 0x46, 0x57, 0xa7, 0x8d, 0x9d, 0x84},
                    {0x90, 0xd8, 0xab, 0x00, 0x8c, 0xbc, 0xd3, 0x0a, 0xf7, 0xe4, 0x58, 0x05, 0xb8, 0xb3, 0x45, 0x06},
                    {0xd0, 0x2c, 0x1e, 0x8f, 0xca, 0x3f, 0x0f, 0x02, 0xc1, 0xaf, 0xbd, 0x03, 0x01, 0x13, 0x8a, 0x6b},
                    {0x3a, 0x91, 0x11, 0x41, 0x4f, 0x67, 0xdc, 0xea, 0x97, 0xf2, 0xcf, 0xce, 0xf0, 0xb4, 0xe6, 0x73},
                    {0x96, 0xac, 0x74, 0x22, 0xe7, 0xad, 0x35, 0x85, 0xe2, 0xf9, 0x37, 0xe8, 0x1c, 0x75, 0xdf, 0x6e},
                    {0x47, 0xf1, 0x1a, 0x71, 0x1d, 0x29, 0xc5, 0x89, 0x6f, 0xb7, 0x62, 0x0e, 0xaa, 0x18, 0xbe, 0x1b},
                    {0xfc, 0x56, 0x3e, 0x4b, 0xc6, 0xd2, 0x79, 0x20, 0x9a, 0xdb, 0xc0, 0xfe, 0x78, 0xcd, 0x5a, 0xf4},
                    {0x1f, 0xdd, 0xa8, 0x33, 0x88, 0x07, 0xc7, 0x31, 0xb1, 0x12, 0x10, 0x59, 0x27, 0x80, 0xec, 0x5f},
                    {0x60, 0x51, 0x7f, 0xa9, 0x19, 0xb5, 0x4a, 0x0d, 0x2d, 0xe5, 0x7a, 0x9f, 0x93, 0xc9, 0x9c, 0xef},
                    {0xa0, 0xe0, 0x3b, 0x4d, 0xae, 0x2a, 0xf5, 0xb0, 0xc8, 0xeb, 0xbb, 0x3c, 0x83, 0x53, 0x99, 0x61},
                    {0x17, 0x2b, 0x04, 0x7e, 0xba, 0x77, 0xd6, 0x26, 0xe1, 0x69, 0x14, 0x63, 0x55, 0x21, 0x0c, 0x7d}
            };


        } else {
            sBox = new int[][]{
                    {0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76},
                    {0xca, 0x82, 0xc9, 0x7d, 0xfa, 0x59, 0x47, 0xf0, 0xad, 0xd4, 0xa2, 0xaf, 0x9c, 0xa4, 0x72, 0xc0},
                    {0xb7, 0xfd, 0x93, 0x26, 0x36, 0x3f, 0xf7, 0xcc, 0x34, 0xa5, 0xe5, 0xf1, 0x71, 0xd8, 0x31, 0x15},
                    {0x04, 0xc7, 0x23, 0xc3, 0x18, 0x96, 0x05, 0x9a, 0x07, 0x12, 0x80, 0xe2, 0xeb, 0x27, 0xb2, 0x75},
                    {0x09, 0x83, 0x2c, 0x1a, 0x1b, 0x6e, 0x5a, 0xa0, 0x52, 0x3b, 0xd6, 0xb3, 0x29, 0xe3, 0x2f, 0x84},
                    {0x53, 0xd1, 0x00, 0xed, 0x20, 0xfc, 0xb1, 0x5b, 0x6a, 0xcb, 0xbe, 0x39, 0x4a, 0x4c, 0x58, 0xcf},
                    {0xd0, 0xef, 0xaa, 0xfb, 0x43, 0x4d, 0x33, 0x85, 0x45, 0xf9, 0x02, 0x7f, 0x50, 0x3c, 0x9f, 0xa8},
                    {0x51, 0xa3, 0x40, 0x8f, 0x92, 0x9d, 0x38, 0xf5, 0xbc, 0xb6, 0xda, 0x21, 0x10, 0xff, 0xf3, 0xd2},
                    {0xcd, 0x0c, 0x13, 0xec, 0x5f, 0x97, 0x44, 0x17, 0xc4, 0xa7, 0x7e, 0x3d, 0x64, 0x5d, 0x19, 0x73},
                    {0x60, 0x81, 0x4f, 0xdc, 0x22, 0x2a, 0x90, 0x88, 0x46, 0xee, 0xb8, 0x14, 0xde, 0x5e, 0x0b, 0xdb},
                    {0xe0, 0x32, 0x3a, 0x0a, 0x49, 0x06, 0x24, 0x5c, 0xc2, 0xd3, 0xac, 0x62, 0x91, 0x95, 0xe4, 0x79},
                    {0xe7, 0xc8, 0x37, 0x6d, 0x8d, 0xd5, 0x4e, 0xa9, 0x6c, 0x56, 0xf4, 0xea, 0x65, 0x7a, 0xae, 0x08},
                    {0xba, 0x78, 0x25, 0x2e, 0x1c, 0xa6, 0xb4, 0xc6, 0xe8, 0xdd, 0x74, 0x1f, 0x4b, 0xbd, 0x8b, 0x8a},
                    {0x70, 0x3e, 0xb5, 0x66, 0x48, 0x03, 0xf6, 0x0e, 0x61, 0x35, 0x57, 0xb9, 0x86, 0xc1, 0x1d, 0x9e},
                    {0xe1, 0xf8, 0x98, 0x11, 0x69, 0xd9, 0x8e, 0x94, 0x9b, 0x1e, 0x87, 0xe9, 0xce, 0x55, 0x28, 0xdf},
                    {0x8c, 0xa1, 0x89, 0x0d, 0xbf, 0xe6, 0x42, 0x68, 0x41, 0x99, 0x2d, 0x0f, 0xb0, 0x54, 0xbb, 0x16}
            };
        }


        String hexStr = Integer.toHexString(b);
        if(hexStr.length() == 1) hexStr = "0"+hexStr;
        String firstIndexStr = hexStr.substring(hexStr.length()-2,hexStr.length()-1);
        String secondIndexStr = hexStr.substring(hexStr.length()-1,hexStr.length());

        String[] hex = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        Map<String, String> hexToDec = new HashMap<>();
        for(int i = 0; i < hex.length; i++) {
            hexToDec.put(hex[i], Integer.toString(i));
        }

        int firstIndex = Integer.parseInt(hexToDec.get(firstIndexStr));
        int secondIndex = Integer.parseInt(hexToDec.get(secondIndexStr));

        //byte result = (byte)sBox[firstIndex][secondIndex];

        byte inv = inverse(b);
        int intInv = Byte.toUnsignedInt(inv);
        int intByte = Byte.toUnsignedInt(b);


        byte result = 0;

        if(inverse) {
            result = (byte)(
                    leftCircShift(intByte,1) ^
                            leftCircShift(intByte,3) ^
                            leftCircShift(intByte,6) ^ 0x5);
        } else {
            result = (byte)(inv ^ leftCircShift(intInv,1) ^
                    leftCircShift(intInv,2) ^
                    leftCircShift(intInv,3) ^
                    leftCircShift(intInv,4) ^ 0x63);
        }

        return inverse ? inverse(result) : result;
    }

    public byte inverse(byte A) {

        if(A == 0) return 0;

        for(byte i = -128; i < 128; i++) {

            int product = multiplyPolynomialsMod(i, A,reductionPolynomial);
            if(product == 1) {
                return i;
            }
        }

        return 0;
    }

    public byte rightCircShift(byte b, int k) {
        return (byte)((b >>> k) | (b << (Byte.SIZE - k)));
    }

    public int leftCircShift(int b, int k) {
        return ((b << k) | (b >>> (Byte.SIZE - k)));
    }

    public String byteToBinaryStr(byte b) {
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }

    public int rConst(int round) {

        int rci = 0;

        if(round == 1) rci = 1;
        else if(round > 1 && rConst(round-1) < 0x80) rci = ((2 * rConst(round-1)));
        else if(round > 1 && rConst(round-1) >= 0x80) rci = (byte)((2 * rConst(round-1)) ^ 0x1b);
        else rci = 0;

        return rci;
    }

}
