package com.prometheus.platform.math;

public class Vectors {

    public static Vector sum(Vector v1, Vector v2) {
        return new Vector(v1.getX() + v2.getX(), v1.getY() + v2.getY(), v1.getZ() + v2.getZ());
    }

    public static Vector subtr(Vector v1, Vector v2) {
        return new Vector(v1.getX() - v2.getX(), v1.getY() - v2.getY(), v1.getZ() - v2.getZ());
    }

    public static double scalarProduct(Vector v1, Vector v2) {
        return v1.getX()*v2.getX() + v1.getY()*v2.getY() + v1.getZ()*v2.getZ();
    }

    public static Vector crossProduct(Vector v1, Vector v2) {

        Matrix m1 = new Matrix(new double[][]{
                new double[]{v1.getY(),v1.getZ()},
                new double[]{v2.getY(),v2.getZ()},
        });

        Matrix m2 = new Matrix(new double[][]{
                new double[]{v1.getX(),v1.getZ()},
                new double[]{v2.getX(),v2.getZ()},
        });

        Matrix m3 = new Matrix(new double[][]{
                new double[]{v1.getX(),v1.getY()},
                new double[]{v2.getX(),v2.getY()},
        });

        return new Vector(m1.det(), -m2.det(), m3.det());
    }

}
