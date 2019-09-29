package com.prometheus.platform.math;

public class MathUtils {

    public static double max(double[] values) {
        double max = values[0];
        for(int i = 1; i < values.length; i++) {
            if(values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }

    public static double min(double[] values) {
        double min = values[0];
        for(int i = 1; i < values.length; i++) {
            if(values[i] < min) {
                min = values[i];
            }
        }
        return min;
    }

}
