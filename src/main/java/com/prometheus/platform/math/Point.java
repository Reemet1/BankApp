package com.prometheus.platform.math;


public class Point {

    public double x;
    public double y;
    public double z;

    public Point(double x, double y) {
        this(x, y, 0);
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //UTILITIES


    public Vector toVector() {
        return new Vector(x,y,z);
    }

    public Point translate(Vector v) {
        x += v.getX();
        y += v.getY();
        z += v.getZ();
        return this;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

}
