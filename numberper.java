package com.company;

import java.util.Scanner;

public class numberper {
    public static void main(String[] args) {

        int uppercase=0,lowercase=0,digit=0,spcl=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the string");
        String inpstr = sc.nextLine();
        int total = inpstr.length();

        for(int i = 0 ; i < inpstr.length(); i++ ){

            Character ch = inpstr.charAt(i);

            if(Character.isUpperCase(ch)){
                uppercase++;
            }
            else if (Character.isLowerCase(ch)){
                lowercase++;

            }
            else if(Character.isDigit(ch)) {
                digit++;
            }
            else {
                spcl++;
            }

        }

        double uppper= (uppercase*100.0)/total;
        System.out.println("UpperCase Percentage : " + uppper);
        double lowper= (lowercase*100.0)/total;
        System.out.println("LowerCase Percentage : " + lowper);
        double dgtper= (digit*100.0)/total;
        System.out.println("Digit Percentage : " + dgtper);
        double spclper= (spcl*100.0)/total;
        System.out.println("SpecialCharacter Percentage : " + spclper);


    }

}
