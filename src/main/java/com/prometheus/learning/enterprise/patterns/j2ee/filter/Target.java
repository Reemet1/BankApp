package com.prometheus.learning.enterprise.patterns.j2ee.filter;

public class Target {
    public void execute(String request){
        System.out.println("Executing request: " + request);
    }
}
