package com.prometheus.learning.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Generics {

    /** Generics allow to use type parameters for classes, constructors and methods.
     * These are then called parametrized types */
    public void generics() {

        /** Class type parameters are defined in diamond bracket */
        List<Integer> intList = new ArrayList<>(); //alternative new ArrayList<Integer>();
        /** add method takes Integer parameters */
        intList.add(Integer.valueOf(2));

        /** If type parameter is not defined, the list takes elements as Object type */
        List objList = new ArrayList();
        /** Adding objects */
        objList.add(Integer.valueOf(2));

        List list1 = new ArrayList<>(); //valid
        List<String> list2 = new ArrayList(); //valid
        list2.get(0).toUpperCase();

        List list3 = new ArrayList<String>(); //valid
        /** Invalid, since only methods of members of type declared as a type parameter
         *  in the declaring type can be used, which in this case is Object */
        //list3.get(0).toUpperCase();

        /** Incompatible types, even though Integer is a suclass of Number */
        //List<Number> list4 = new ArrayList<Integer>();

        /** When declaring variable with diamond brackets, a parameter type must be given */
        //List<> list5 = new ArrayList();

        Circle circle = new Circle();
        Triangle triangle = new Triangle();
        Rectangle rectangle = new Rectangle();

        /** Currently any specific shape can be added into the shape collection */
        ShapeCollection shapeCollection = new ShapeCollection();
        shapeCollection.addShape(circle);
        shapeCollection.addShape(triangle);
        shapeCollection.addShape(rectangle);

        /** If we want only the specific type of shapes can be added into the shapeCollection,
         *  we could either create 3 collection classes for each shape type, which is a bad practice
         *  since it creates duplicate code, or better, use a generic type with the class ShapeCollection
         */

        GenericShapeCollection<Circle> circleCollection = new GenericShapeCollection<>();
        circleCollection.addShape(circle);
        /** Only objects of type Circle can now be added into the generic shape collection. If
         *  the type Circle would not be specified, all types could still be added, since
         *  they would be handled as type Object */
        //circleCollection.addShape(rectangle);
        //circleCollection.addShape(triangle);

        /** It is still possible to break the GenericShapeCollection though, by creating
         *  it with type parameter that is not the intended Shape type. */
        GenericShapeCollection<String> brokenCollection = new GenericShapeCollection<>();
        brokenCollection.addShape("Not a shape");

        /** Can't use String as type parameter in FixedGenericShapeCollection, since the class
         *  only accepts type parameters that extend Shape */
        //FixedGenericShapeCollection<String> fixedGenericShapeCollection = new FixedGenericShapeCollection<>();
    }

    /** To avoid incorrect objects being added to a shape collection, the type
     * parameter has to be specified in a method's parameter also. */
    public void handleShapeCollection(FixedGenericShapeCollection<Circle> shapeCollection) {
        Circle circle = new Circle();
        Triangle triangle = new Triangle();
        shapeCollection.addShape(circle);
        /** Can't be added, since in method arguments the type parameter defined as Circle */
        //shapeCollection.addShape(triangle);
    }

    public class ShapeCollection {

        List<Shape> shapeCollection = new ArrayList<>();

        public void addShape(Shape shape) {
            shapeCollection.add(shape);
        }

    }

    /** A type T is now defined with the class */
    public class GenericShapeCollection<T> {

        /** This class now deals with objects of type T */
        List<T> shapeCollection = new ArrayList<>();

        /** This class now deals with objects of type T */
        public void addShape(T shape) {
            shapeCollection.add(shape);
            /** Since the actual type of T is not known, only methods from Object class can be used */
            //System.out.println("Added shape " + shape.getName());

            /** Alternatively the type can be cast into Shape */
            System.out.println("Added shape" + ((Shape)shape).getName());
        }

    }

    /** Generic class with bounded type parameter T*/
    public class FixedGenericShapeCollection<T extends Shape> {
        /** This class now deals with objects of type T that extends Shape*/
        List<T> shapeCollection = new ArrayList<>();

        /** This class now deals with objects of type T that extends Shape*/
        public void addShape(T shape) {
            shapeCollection.add(shape);

            /** Since the type T is now bounded, and known as a type Shape, the casting
             * into Shape can be removed and the method in Shape can be used */
            System.out.println("Added shape " + shape.getName());
        }
    }

    public interface Shape {

        public String getName();

    }

    /** Interfaces can also be generic */
    public interface GenericShape<T> {

    }

    /** Type parameter T can be bounded with multiple classes. Since classes can only extend
     * one class and implement multiple interfaces, the syntax for multiple type bounds is
     * that the first bound must be a class, and the remaining bounds are interfaces */
    public class MultipleTypeBoundGenericClass<T extends String & List & Collection> {

    }

    /** Multiple type parameters can be defined, and each of them can be bounded */
    public class MultipleTypesGenericClass1<T,U,V extends String> {

    }

    /** Multiple type parameters each with different bound */
    public class MultipleTypesGenericClass2<T extends String, V extends Number> {

    }

    public class Rectangle implements Shape {

        public String getName() {
            return "Rectangle";
        }

    }

    public class Triangle implements Shape {

        public String getName() {
            return "Triangle";
        }

    }

    public class Circle implements Shape {

        public String getName() {
            return "Circle";
        }

    }
}
