package com.prometheus.learning.basics;

public class Main {

    public static void main(String[] args) {

        int[] nrs = {1};
        int[] args1 = method(nrs);
        nrs[0] = 2;
        System.out.println(args1[0]);

    }

    static int[] method(int[] args) {
        args[0] = 5;
        return args;
    }


}
