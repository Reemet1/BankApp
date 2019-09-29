package com.prometheus.platform.math;

public class Vector {

    private double x;
    private double y;
    private double z;

    public Vector(double x, double y) {
        this(x, y, 0);
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Point p1, Point p2) {
        x = p2.getX() - p1.getX();
        y = p2.getY() - p1.getY();
        z = p2.getZ() - p1.getZ();
    }

    public Vector(Point p) {
        x = p.getX();
        y = p.getY();
        z = p.getZ();
    }

    public double length() {
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
    }

    public Vector scale(double scalar) {
        x = scalar*x;
        y = scalar*y;
        z = scalar*z;
        return this;
    }

    public Vector normalize() {
        if(length() > 0) {
            double length = length();
            x = x/length;
            y = y/length;
            z = z/length;
        }
        return this;
    }

    public Vector add(Vector v) {
        x += v.getX();
        y += v.getY();
        z += v.getZ();
        return this;
    }

    public Vector substr(Vector v) {
        x -= v.getX();
        y -= v.getY();
        z -= v.getZ();
        return this;
    }

    public Vector perp() {
        return new Vector(-y, x);
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
