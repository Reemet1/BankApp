package com.prometheus.learning.enterprise.patterns.creational.abstractfactory;

public class RedSquare implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside RedSquare::draw() method.");
    }
}
