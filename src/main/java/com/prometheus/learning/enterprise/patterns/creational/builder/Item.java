package com.prometheus.learning.enterprise.patterns.creational.builder;

public interface Item {
    public String name();
    public Packing packing();
    public float price();
}