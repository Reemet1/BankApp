package com.prometheus.learning.enterprise.patterns.j2ee.business_delegate;

public class EJBService implements BusinessService {

    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking EJB Service");
    }
}
