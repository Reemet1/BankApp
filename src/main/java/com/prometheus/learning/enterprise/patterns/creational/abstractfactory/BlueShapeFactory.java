package com.prometheus.learning.enterprise.patterns.creational.abstractfactory;

public class BlueShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new BlueRectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new BlueSquare();
        }
        return null;
    }
}
