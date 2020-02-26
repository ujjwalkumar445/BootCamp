package exercise2;

import java.util.Scanner;

public class Q8A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word");
        String word =sc.next();
        while(!word.equals("done")){
            if(word.charAt(0)==word.charAt(word.length()-1)){
                System.out.println("First and last word are equals : " + word);
            } else {
                System.out.println("First and last word are not equal : " + word);
            }
            word=sc.next();
        }
    }
}
