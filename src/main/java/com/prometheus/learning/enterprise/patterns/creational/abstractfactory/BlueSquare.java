package com.prometheus.learning.enterprise.patterns.creational.abstractfactory;

public class BlueSquare implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside BlueSquare::draw() method.");
    }
}
