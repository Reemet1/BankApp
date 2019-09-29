package com.prometheus.bank.logger;


import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

public class LoggerMain {

    public static void main(String[] args) {
        //Logger logger = Logger.getLogger(LoggerMain.class);
        //PropertyConfigurator.configure("log4j.properties");
        //logger.info("Logger info");

        Logger.logger.info("Testing log");



    }

}
