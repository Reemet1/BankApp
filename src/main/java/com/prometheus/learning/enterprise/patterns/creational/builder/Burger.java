package com.prometheus.learning.enterprise.patterns.creational.builder;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
