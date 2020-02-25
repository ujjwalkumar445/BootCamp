package collection;

import java.util.HashMap;
import java.util.Scanner;

public class Q3_occurence {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string :");
        String s1 = sc.nextLine();
        HashMap<Character, Integer> h1 = new HashMap<Character, Integer>();
        char[] s2 = s1.toCharArray();
        for (char c : s2){
           // System.out.println(c);
            if(h1.containsKey(c)){
                h1.put(c,h1.get(c)+1);
            }
            else {
                h1.put(c,1);
            }
        }
        System.out.println(s1 + " : "+h1);
    }
}
