package com.prometheus.learning.enterprise.patterns.creational.abstractfactory;

public class RedRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside RedRectangle::draw() method.");
    }
}
