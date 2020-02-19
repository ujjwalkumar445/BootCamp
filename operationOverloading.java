package com.company;

public class operationOverloading {

    public int add (int x, int y){
        return (x+y);
    }
    public double add (double x, double y){
        return (x+y);
    }
    public float mul (float x, float y){
        return (x*y);
    }
    public int mul (int x, int y){
        return (x*y);
    }
    public String concat (String x, String y){
        return (x+y);
    }
    public String concat (String x,String y, String z){
        return (x+y+z);
    }

    public static void main(String[] args) {

        operationOverloading a = new operationOverloading();
        System.out.println(a.add(10, 20));
        System.out.println(a.add(10.5, 20.5));
        System.out.println(a.mul(10, 20));
        System.out.println(a.mul(1, 2));
        System.out.println(a.concat("Ujjwal", " Chikara"));
        System.out.println(a.concat("Ujjwal", " Freakin", "Chikara"));
    }
}
