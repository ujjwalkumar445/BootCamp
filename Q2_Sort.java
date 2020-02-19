package exercise2;

import java.util.Scanner;

public class Q2_Sort {
    public static void main(String[] args) {

        char temp = 0;

        Scanner sc = new Scanner(System.in);
        String str = new String();
        str = sc.nextLine();
        char words[] = str.toCharArray();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[j] > words[i]) {
                    temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;

                }
            }
        }
        for (int j = 0; j < words.length; j++) {
           System.out.println(words[j]);

        }
    }
}
