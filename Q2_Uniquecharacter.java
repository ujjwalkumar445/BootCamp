package collection;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q2_Uniquecharacter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        //splitting the string into one word
        String s2[] = s1.split("");
        Set<String> set1 = new HashSet<String>();
        for(int i = 0; i< s2.length; i++) {
            set1.add(s2[i]);
        }
        System.out.println("no of unique character in String :" + set1.size());
    }
}
