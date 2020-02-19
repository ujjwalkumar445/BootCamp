package com.company;

import java.util.Scanner;

public class commonelemarray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the size of array");
        int n =sc.nextInt();

        System.out.println("enter the element in second array");
        int arr[] = new int[n];
        for(int i= 0; i< arr.length; i++){

            arr[i]=sc.nextInt();

        }
        System.out.println("\nEnter the size of second array");
        int n1 = sc.nextInt();

        System.out.println("enter the element in second array");
        int arr1[] = new int[n1];
        for(int j = 0; j < arr1.length; j++){
            arr1[j] = sc.nextInt();
        }

        for(int i = 0; i < arr.length ; i++){
            for(int j = 0; j < arr1.length; j++){
                if(arr[i]==arr1[j]){
                    System.out.println(arr[i]);
                }
            }
        }
    }
}
