package com.prometheus.learning.enterprise.patterns.structural.facade;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}