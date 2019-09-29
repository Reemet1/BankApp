package com.prometheus.bank.security.crypto.custom.utils;

import java.util.HashMap;
import java.util.Map;

public class BaseConverter {

    private static Map<String, String> binToHex = new HashMap<>();
    private static Map<String, String> hexToBin = new HashMap<>();

    static {
        String[] hex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        String[] bin = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};

        for(int i = 0; i < hex.length; i++) {
            hexToBin.put(hex[i], bin[i]);
            binToHex.put(bin[i],hex[i]);
        }
    }

    //a_n a_(n-1) ... a_1 a_0 = a_n * 2^n + a_{n-1} * 2^{n-1} + ... + a_1 * 2 + a_0 * 1
    public static String binToDec(String binary) {
        char[] bits = binary.toCharArray();
        int dec = 0;
        int n = bits.length;

        for(int i = 0; i < n; i++) {
            dec += Character.getNumericValue(bits[i])*Math.pow(2,n-i-1);
        }

        return Integer.toString(dec);
    }

    public static String decToBin(String decimal) {

        int dec = Integer.parseInt(decimal);

        StringBuilder binary = new StringBuilder();

        int pow = 0;

        while(dec / Math.pow(2,pow) >= 1) {
            pow++;
        }

        for(int i = pow; i >= 0; i--) {
            if(dec / Math.pow(2,i) >= 1) {
                binary.append("1");
                dec = (int)(dec % Math.pow(2,i));
            } else binary.append("0");
        }

        return new String(binary);
    }

    public static String octToDec(String oct) {
        char[] octNrs = oct.toCharArray();
        int dec = 0;
        int n = octNrs.length;

        for(int i = 0; i < n; i++) {
            dec += Character.getNumericValue(octNrs[i])*Math.pow(8,n-i-1);
        }

        return Integer.toString(dec);
    }

    public static String hexToBin(String hex) {

        StringBuilder bin = new StringBuilder();
        for(char ch : hex.toCharArray()) {
            bin.append(hexToBin.get(Character.toString(ch)));
        }

        return new String(bin);
    }

    public static String binToHex(String binary) {

        StringBuilder hex = new StringBuilder();
        String[] words = new String[binary.length()/4];

        for(int i = 0; i < words.length; i++) {
            hex.append(binToHex.get(binary.substring(4*i, 4*(i+1))));
        }

        return new String(hex);
    }



}
