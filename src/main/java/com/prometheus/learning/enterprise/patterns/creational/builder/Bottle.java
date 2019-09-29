package com.prometheus.learning.enterprise.patterns.creational.builder;

public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}
