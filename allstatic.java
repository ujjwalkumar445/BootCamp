package com.company;

public class allstatic {

    static String fname = "ujjwal";
    static String lastname = "kumar";
    static int age = 22;

    static {
        System.out.println("we are in static block");
        System.out.println("firstName = Ujjwal lastName = kumar Age = 22 ");
    }

    public static void PrintName(String fname, String lastname, int age){
        System.out.println("we are in static method");
        System.out.println("Name: " + fname + " lastName: " + lastname + " Age: " + age);
    }

    public static void main(String[] args) {
        PrintName("Ujjwal", "Kumar",22);

        System.out.println("we are using static variable");
        System.out.println("Name: " + fname + " lastName: " + lastname + " Age: " + age);
    }



}
