package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class repeatedelemarray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("\nEnter the size of array");
        int arr[] = new int[n];
        System.out.println("Enter the number in array");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        boolean flag= true;
//        for(int i = 0; i < n-1 ; i++) {
//            System.out.println(arr[i]);
//        }
      //  int max = arr.length;


        for(int j = 0; j < n-1; j = j+2){
            if(arr[j] != arr[j+1]){
                System.out.println(arr[j]);
                flag = false;
               break;
            }
        }
        if(flag ){
            System.out.println(arr[n-1]);
        }

    }
}
