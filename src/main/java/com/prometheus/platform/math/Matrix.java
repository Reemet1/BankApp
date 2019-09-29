package com.prometheus.platform.math;

public class Matrix {

    private double[][] matrix;

    public Matrix(double[][] mat) {
        matrix = mat;
    }


    public double det() {
        if(rows() != cols()) throw new RuntimeException("The matrix is not square matrix. Cannot find determinant");

        if(rows() == 2 && cols() == 2) {
            return det2x2();
        }

        if(rows() == 3 && cols() == 3) {

            return det3x3();
        }
        return 0;
    }

    private double det2x2() {
        if(rows() != cols()) throw new RuntimeException("The matrix is not square matrix. Cannot find determinant");
        return matrix[0][0]*matrix[1][1]-matrix[1][0]*matrix[0][1];
    }

    private double det3x3() {
        if(rows() != cols()) throw new RuntimeException("The matrix is not square matrix. Cannot find determinant");
        double det = matrix[0][0]*matrix[1][1]*matrix[2][2]
                + matrix[1][0]*matrix[2][1]*matrix[0][2]
                + matrix[0][1]*matrix[1][2]*matrix[2][0]
                - matrix[2][0]*matrix[1][1]*matrix[0][2]
                - matrix[1][0]*matrix[0][1]*matrix[2][2]
                - matrix[1][2]*matrix[2][1]*matrix[0][0];
        return det;
    }

    public double get(int x, int y) {
        return matrix[x][y];
    }

    public int rows() {
        return matrix.length;
    }

    public int cols() {
        return matrix[0].length;
    }
}
