package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Q1_list {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float element;
        ArrayList<Float> l1 = new ArrayList<Float>();
        System.out.println("enter 5 element");
        for (int i = 0; i < 5; i++) {
            element = sc.nextFloat();
            l1.add(element);
        }
        float sum = 0f;
        Iterator<Float> iterator = l1.iterator();
        while (iterator.hasNext()) {
            sum = sum + iterator.next();
        }
        System.out.println("sum of list is : " + sum);
    }
}
