package com.prometheus.learning.enterprise.patterns.creational.abstractfactory;

public class RedShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RedRectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new RedSquare();
        }
        return null;
    }
}
