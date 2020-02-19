package com.company;

import java.util.Scanner;

public class bufferprgm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer inpstr = new StringBuffer();
        inpstr.append(sc.nextLine());
        inpstr.reverse();
        System.out.println("Reverse String : " + inpstr);
        inpstr.delete(4,6);
        System.out.println("New String : " + inpstr);
    }
}
