package com.prometheus.learning.enterprise.patterns.j2ee.filter;

public class AuthenticationFilter implements Filter {
    public void execute(String request){
        System.out.println("Authenticating request: " + request);
    }
}
