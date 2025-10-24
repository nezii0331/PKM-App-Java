// src/main/java/com/fran/pkm/PkmApplication.java
package com.fran.pkm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * PKM App - Personal Knowledge Management System
 * Main application class
 */

 @SpringBootApplication
 public class PkmApplication{
    /**
     * Main method - entry point of the application
     * @param args command line arguments
     */
    public static void main(String[] args){
        SpringApplication.run(PkmApplication.class, args);
    }
 }

