package com.prometheus.learning.enterprise.patterns.creational.factory;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
