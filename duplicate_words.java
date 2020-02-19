package com.company;

import java.util.Scanner;

public class duplicate_words {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the String");
        String inStr = sc.nextLine();
        inStr = inStr.toLowerCase();
        String words[] = inStr.split("");

        for (int i = 0; i < words.length; i++){
            int count = 1;
            for (int j = i+1; j < words.length; j++){
                if(words[i].equals(words[j])){
                    count ++;
                    words[j]= "NULL";
                }
            }
            if(count > 1 && words[i] != "NULL"){
                System.out.println(words[i] + " : " + count);
            }
        }
    }
}
