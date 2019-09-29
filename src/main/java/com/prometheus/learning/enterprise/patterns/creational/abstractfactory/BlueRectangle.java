package com.prometheus.learning.enterprise.patterns.creational.abstractfactory;

public class BlueRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside BlueRectangle::draw() method.");
    }
}