package exercise2;

import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the seconds");
        int ns = sc.nextInt();

        int day = ns/(24*3600);
        int hour = (ns%(24*3600))/3600;
        int s= (ns%(24*3600));
        int s1 = s%3600;
        int minute = s1/60;
        int s2 = s1%60;
        int seconds = (s2);

        System.out.println("Converted second into dhms : " + day +" : "  + hour + " : " + minute + " : " + seconds);
    }
}
