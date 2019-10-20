package com.prometheus.crypto.impl;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;

/**
 * SHA digest algorithm, implemented by the specification:
 * https://nvlpubs.nist.gov/nistpubs/FIPS/NIST.FIPS.180-4.pdf
 */
public class SecureHash {

    Algorithm algorithm;

    public SecureHash(Algorithm algorithm) {
        this.algorithm = algorithm;
    }


    public byte[] getHashSha512(byte[] message) throws Exception {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        long[][] parsedPaddedMessage = preProcess(message);

        int N = parsedPaddedMessage.length;

        long[][] H = new long[N+1][8];
        H[0] = getInitialHash();

        for(int i = 1; i <= N; i++) {
            long[] W = getMessageSchedule(parsedPaddedMessage[i-1]);
            //long[] W = parsedPaddedMessage[i-1];
            long a = H[i-1][0];
            long b = H[i-1][1];
            long c = H[i-1][2];
            long d = H[i-1][3];
            long e = H[i-1][4];
            long f = H[i-1][5];
            long g = H[i-1][6];
            long h = H[i-1][7];

            long[] K = getConstants();
            for(int t = 0; t < 80; t++) {

                if(t == 27) {
                    System.out.println();
                }

                long T1 = h + sum1(e) + ch(e,f,g) + K[t] + W[t];
                long T2 = sum0(a) + maj(a,b,c);
                h = g;
                g = f;
                f = e;
                e = d + T1;
                d = c;
                c = b;
                b = a;
                a = T1 + T2;
                //System.out.println("------------- " +t+" --------------");
                System.out.println("W["+t+"] = " + Long.toHexString(W[t]));
                System.out.println("a = " + Long.toHexString(a));
                System.out.println("b = " + Long.toHexString(b));
                System.out.println("c = " + Long.toHexString(c));
                System.out.println("d = " + Long.toHexString(d));
                System.out.println("e = " + Long.toHexString(e));
                System.out.println("f = " + Long.toHexString(f));
                System.out.println("g = " + Long.toHexString(g));
                System.out.println("h = " + Long.toHexString(h));
            }


            H[i][0] = a + H[i-1][0];
            H[i][1] = b + H[i-1][1];
            H[i][2] = c + H[i-1][2];
            H[i][3] = d + H[i-1][3];
            H[i][4] = e + H[i-1][4];
            H[i][5] = f + H[i-1][5];
            H[i][6] = g + H[i-1][6];
            H[i][7] = h + H[i-1][7];
        }

        StringBuilder hash = new StringBuilder();
        for(int i = 0; i < 8; i++) {
            hash.append(Long.toHexString(H[N][i]) + " ");
            byteArrayOutputStream.write(Utils.longToBytes(H[N][i]));
        }

        System.out.println(hash.toString());
        return byteArrayOutputStream.toByteArray();

    }

    public long[] getMessageSchedule(long[] messageBlock) {

        long[] messageSchedule = new long[80];

        for(int t = 0; t < 80; t++) {
            messageSchedule[t] = W(messageBlock, t);
        }

        return messageSchedule;
    }

    public long W(long[] messageBlock, int t) {
        long messageSchedule;
        if(t <= 15) {
            messageSchedule = messageBlock[t];
        } else if(t <= 79) {
            messageSchedule = sigma1(W(messageBlock, t-2)) + W(messageBlock, t-7) +
                    sigma0(W(messageBlock, t-15)) + W(messageBlock, t-16);

        } else {
            messageSchedule = 0;
        }

        return messageSchedule;
    }

    public long[][] preProcess(byte[] message) {

        byte[] paddedMessage = padMessage(message);
        return parsePaddedMessage(paddedMessage);
    }

    public byte[] padMessage(byte[] message) {
        int len = 8*message.length;

        String binStr = Utils.bytesToBinaryStr(message);
        StringBuilder binaryStr = new StringBuilder(binStr);

        binaryStr.append("1");

        int k = 0;
        if(algorithm.equals(Algorithm.SHA1) || algorithm.equals(Algorithm.SHA256)) {
            k = 448 - (len + 1);
        } else if(algorithm.equals(Algorithm.SHA384) || algorithm.equals(Algorithm.SHA512)) {

            k = (1024-128-len-1 >= 0) ? 1024-128-len-1+64 : 1024 + (1024-128-len-1)+64;
        }

        for(int i = 0; i < k; i++) {
            binaryStr.append("0");
        }

        binaryStr.append(Utils.longToBinaryStr(len));

        byte[] padded = new BigInteger(new String(binaryStr), 2).toByteArray();

        return padded;
    }

    public long[][] parsePaddedMessage(byte[] paddedMessage) {

        long[][] blocks = null;

        if(algorithm.equals(Algorithm.SHA1) || algorithm.equals(Algorithm.SHA256)) {
            blocks = new long[paddedMessage.length*8/512][16];
            for(int i = 0; i < paddedMessage.length*8/512; i++) {
                for(int j = 0; j < 16; j++) {
                    byte[] bytes = new byte[]{paddedMessage[64*i + 4*j], paddedMessage[64*i + 4*j + 1], paddedMessage[64*i + 4*j + 2], paddedMessage[64*i + 4*j + 3]};
                    blocks[i][j] = ByteBuffer.wrap(bytes).getInt();
                }
            }
        } else if(algorithm.equals(Algorithm.SHA384) || algorithm.equals(Algorithm.SHA512)) {
            blocks = new long[paddedMessage.length*8/1024][16];
            for(int i = 0; i < paddedMessage.length*8/1024; i++) {
                for(int j = 0; j < 16; j++) {
                    byte[] bytes = new byte[]{paddedMessage[128*i + 8*j], paddedMessage[128*i + 8*j + 1], paddedMessage[128*i + 8*j + 2], paddedMessage[128*i + 8*j + 3],paddedMessage[128*i + 8*j + 4],paddedMessage[128*i + 8*j + 5],paddedMessage[128*i + 8*j + 6],paddedMessage[128*i + 8*j + 7]};
                    //blocks[i][j] = ByteBuffer.wrap(bytes).getLong();
                    blocks[i][j] = Utils.bytesToLong(bytes);
                }
            }
        }

        return blocks;
    }

    public long[] getInitialHash() {

        long[] hash;

        if(algorithm.equals(Algorithm.SHA1)) {
            hash = new long[] {0x67452301, 0xefcdab89, 0x98badcfe, 0x10325476, 0xc3d2e1f0};
        } else if(algorithm.equals(Algorithm.SHA256)) {
            hash = new long[] {
                    0x6a09e667, 0xbb67ae85, 0x3c6ef372, 0xa54ff53a,
                    0x510e527f, 0x9b05688c, 0x1f83d9ab, 0x5be0cd19
            };
        } else if(algorithm.equals(Algorithm.SHA384)) {
            hash = new long[] {
                    0xcbbb9d5dc1059ed8L, 0x629a292a367cd507L, 0x9159015a3070dd17L, 0x152fecd8f70e5939L,
                    0x67332667ffc00b31L, 0x8eb44a8768581511L, 0xdb0c2e0d64f98fa7L, 0x47b5481dbefa4fa4L
            };
        } else if(algorithm.equals(Algorithm.SHA512)) {
            hash = new long[] {
                    0x6a09e667f3bcc908L, 0xbb67ae8584caa73bL, 0x3c6ef372fe94f82bL, 0xa54ff53a5f1d36f1L,
                    0x510e527fade682d1L, 0x9b05688c2b3e6c1fL, 0x1f83d9abfb41bd6bL, 0x5be0cd19137e2179L
            };
        } else hash = new long[0];

        return hash;
    }

    public boolean[] toBitArray(byte[] bytes) {
        boolean[] bitArray = new boolean[8*bytes.length];
        for(int i = 0; i < bytes.length; i++) {
            String byteStr = Utils.byteToBinaryStr(bytes[i]);
            for(int j = 0; j < 8; j++) {
                if(byteStr.charAt(j) == '1') bitArray[8*i+j] = true;
                else bitArray[8*i+j] = false;
            }
        }
        return bitArray;
    }

    public long ch(long x, long y, long z) {
        return (x & y) ^ (~x & z);
    }

    public long parity(long x, long y, long z) {
        return x ^ y ^ z;
    }

    public long maj(long x, long y, long z) {
        return (x & y) ^ (x & z) ^ (y & z);
    }

    public long shr(long x, long n) {
        return x >>> n;
    }

    public long rotr(long x, long n) {
        return (x >> n) | (x << 64 - n);
    }

    public long rotl(long x, long n) {
        return (x << n) | (x >> 64 - n);
    }

    public long sum0(long x) {
        if(algorithm.equals(Algorithm.SHA256)) {
            return rotr(x, 2) ^ rotr(x, 13) ^ rotr(x, 22);
        } else if(algorithm.equals(Algorithm.SHA384) || algorithm.equals(Algorithm.SHA512)) {
            return rightCircShift(x, 28) ^ rightCircShift(x, 34) ^ rightCircShift(x, 39);
        } else return 0;

    }

    public long sum1(long x) {
        if(algorithm.equals(Algorithm.SHA256)) {
            return rotr(x, 6) ^ rotr(x, 11) ^ rotr(x, 25);
        } else if(algorithm.equals(Algorithm.SHA384) || algorithm.equals(Algorithm.SHA512)) {
            return rightCircShift(x, 14) ^ rightCircShift(x, 18) ^ rightCircShift(x, 41);
        } else return 0;
    }

    public long rightCircShift(long b, int k) {
        return ((b >>> k) | (b << (Long.SIZE - k)));
    }

    public long leftCircShift(long b, int k) {
        return ((b << k) | (b >>> (Long.SIZE - k)));
    }

    public long sigma0(long x) {
        if(algorithm.equals(Algorithm.SHA256)) {
            return rotr(x, 7) ^ rotr(x, 18) ^ shr(x, 3);
        } else if(algorithm.equals(Algorithm.SHA384) || algorithm.equals(Algorithm.SHA512)) {
            return rightCircShift(x, 1) ^ rightCircShift(x, 8) ^ shr(x, 7);
        } else return 0;
    }

    public long sigma1(long x) {
        if(algorithm.equals(Algorithm.SHA256)) {
            return rotr(x, 17) ^ rotr(x, 19) ^ shr(x, 10);
        } else if(algorithm.equals(Algorithm.SHA384) || algorithm.equals(Algorithm.SHA512)) {
            return rightCircShift(x, 19) ^ rightCircShift(x, 61) ^ shr(x, 6);
        } else return 0;
    }

    public long[] getConstants() {

        long[] constants;

        if(algorithm.equals(Algorithm.SHA1)) {
            constants = new long[80];
            for(int t = 0; t <= 19; t++)  constants[t] = 0x5a827999;
            for(int t = 20; t <= 39; t++) constants[t] = 0x6ed9eba1;
            for(int t = 40; t <= 59; t++) constants[t] = 0x8f1bbcdc;
            for(int t = 60; t <= 79; t++) constants[t] = 0xca62c1d6;

        } else if(algorithm.equals(Algorithm.SHA256)) {
            constants = new long[]
                    {0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
                            0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
                            0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
                            0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967,
                            0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
                            0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
                            0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3,
                            0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2};

        } else if(algorithm.equals(Algorithm.SHA384) || algorithm.equals(Algorithm.SHA512)) {
            constants = new long[] {
                    0x428a2f98d728ae22L, 0x7137449123ef65cdL, 0xb5c0fbcfec4d3b2fL, 0xe9b5dba58189dbbcL, 0x3956c25bf348b538L,
                    0x59f111f1b605d019L, 0x923f82a4af194f9bL, 0xab1c5ed5da6d8118L, 0xd807aa98a3030242L, 0x12835b0145706fbeL,
                    0x243185be4ee4b28cL, 0x550c7dc3d5ffb4e2L, 0x72be5d74f27b896fL, 0x80deb1fe3b1696b1L, 0x9bdc06a725c71235L,
                    0xc19bf174cf692694L, 0xe49b69c19ef14ad2L, 0xefbe4786384f25e3L, 0x0fc19dc68b8cd5b5L, 0x240ca1cc77ac9c65L,
                    0x2de92c6f592b0275L, 0x4a7484aa6ea6e483L, 0x5cb0a9dcbd41fbd4L, 0x76f988da831153b5L, 0x983e5152ee66dfabL,
                    0xa831c66d2db43210L, 0xb00327c898fb213fL, 0xbf597fc7beef0ee4L, 0xc6e00bf33da88fc2L, 0xd5a79147930aa725L,
                    0x06ca6351e003826fL, 0x142929670a0e6e70L, 0x27b70a8546d22ffcL, 0x2e1b21385c26c926L, 0x4d2c6dfc5ac42aedL,
                    0x53380d139d95b3dfL, 0x650a73548baf63deL, 0x766a0abb3c77b2a8L, 0x81c2c92e47edaee6L, 0x92722c851482353bL,
                    0xa2bfe8a14cf10364L, 0xa81a664bbc423001L, 0xc24b8b70d0f89791L, 0xc76c51a30654be30L, 0xd192e819d6ef5218L,
                    0xd69906245565a910L, 0xf40e35855771202aL, 0x106aa07032bbd1b8L, 0x19a4c116b8d2d0c8L, 0x1e376c085141ab53L,
                    0x2748774cdf8eeb99L, 0x34b0bcb5e19b48a8L, 0x391c0cb3c5c95a63L, 0x4ed8aa4ae3418acbL, 0x5b9cca4f7763e373L,
                    0x682e6ff3d6b2b8a3L, 0x748f82ee5defb2fcL, 0x78a5636f43172f60L, 0x84c87814a1f0ab72L, 0x8cc702081a6439ecL,
                    0x90befffa23631e28L, 0xa4506cebde82bde9L, 0xbef9a3f7b2c67915L, 0xc67178f2e372532bL, 0xca273eceea26619cL,
                    0xd186b8c721c0c207L, 0xeada7dd6cde0eb1eL, 0xf57d4f7fee6ed178L, 0x06f067aa72176fbaL, 0x0a637dc5a2c898a6L,
                    0x113f9804bef90daeL, 0x1b710b35131c471bL, 0x28db77f523047d84L, 0x32caab7b40c72493L, 0x3c9ebe0a15c9bebcL,
                    0x431d67c49c100d4cL, 0x4cc5d4becb3e42b6L, 0x597f299cfc657e2aL, 0x5fcb6fab3ad6faecL, 0x6c44198c4a475817L
            };
        } else {
            constants = new long[0];
        }

        return constants;
    }

    public enum Algorithm {
        SHA1,
        SHA256,
        SHA384,
        SHA512
    }


}

