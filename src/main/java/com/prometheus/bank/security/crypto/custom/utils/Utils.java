package com.prometheus.bank.security.crypto.custom.utils;

public class Utils {

    public static String byteToBinaryStr(byte b) {
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }

    public static String intToBinaryStr(int i) {
        return String.format("%32s", Integer.toBinaryString(i& 0xFF)).replace(' ', '0');
    }

    public static String bytesToBinaryStr(byte[] bytes) {

        StringBuilder binaryStr = new StringBuilder();

        for(byte b : bytes) {
            binaryStr.append(byteToBinaryStr(b));
        }

        return new String(binaryStr);
    }

    public static boolean[] toBitArray(String bitStr) {

        boolean[] bitArray = new boolean[bitStr.length()];

        char[] bitChars = bitStr.toCharArray();

        for(int i = 0; i < bitChars.length; i++) {
            if(bitChars[i] == '1') bitArray[i] = true;
            else if(bitChars[i] == '0') bitArray[i] = false;
            else throw new RuntimeException("Incorrect bit string");
        }

        return bitArray;
    }

    public static byte[] binaryStrToBytes(String binaryStr) {

        byte[] bytes = new byte[binaryStr.length()/8];

        for(int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte)Integer.parseInt(binaryStr.substring(8*i, 8*(i+1)),2);
        }
        return bytes;
    }

}
