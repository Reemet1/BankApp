package com.prometheus.learning.enterprise.patterns.creational.abstractfactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(ShapeColor shapeColor){
        if(shapeColor == ShapeColor.RED){
            return new RedShapeFactory();
        }else if(shapeColor == ShapeColor.BLUE) {
            return new BlueShapeFactory();
        } else return new ShapeFactory();
    }

    public enum ShapeColor {
        RED,
        BLUE,
        COLORLESS
    }
}