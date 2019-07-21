package com.damon.kafka;


import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    private static Logger log = Logger.getLogger(App.class.getClass());

    public App() {
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}