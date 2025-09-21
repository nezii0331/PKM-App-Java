package com.fran.pkm;

/**
 * Hello World example class
 * This was originally in WEEK1/hello.java
 */
public class Hello {
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("Welcome to PKM App Java project!");
    }
    
    /**
     * Get a greeting message
     * @param name the name to greet
     * @return greeting message
     */
    public String getGreeting(String name) {
        return "Hello, " + name + "!";
    }
}
