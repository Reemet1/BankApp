package com.prometheus.learning.enterprise.patterns.j2ee.filter;

public class DebugFilter implements Filter {
    public void execute(String request){
        System.out.println("request log: " + request);
    }
}
