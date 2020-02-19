package com.company;

import java.util.Scanner;

public class Q3_occurence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inpstr1 = new String();
        inpstr1 = sc.nextLine();

        String inpstr2 = new String();
        inpstr2 = sc.nextLine();

        int count = inpstr1.length() - inpstr1.replace(inpstr2,"").length();

        System.out.println("Occurence of " + inpstr2 + ":" + count);


    }
}
