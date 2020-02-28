package collection;


import java.util.*;

public class Q7_frequency {

    private static void sortByfrequency(int[]inputArray){
        Map<Integer, Integer> elemcount = new LinkedHashMap<>();
        for(int i = 0;i < inputArray.length; i++){
            if(elemcount.containsKey(inputArray[i])){
                elemcount.put(inputArray[i],elemcount.get(inputArray[i])+1);
            } else {
                elemcount.put(inputArray[i],1);
            }
        }

        ArrayList<Integer> sortedElements = new ArrayList<>();

        elemcount.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> {
                    for(int i =1 ; i<=entry.getValue();i++)
                        sortedElements.add(entry.getKey());
                } );
        System.out.println("elements with frequency is" +elemcount);
        System.out.println("Sorted array elements in descending order of their frequency : ");
        System.out.println(sortedElements);
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        //enter the array in the array
        for(int i = 0; i< n; i++){
            ar[i]=sc.nextInt();
        }
        //array is printed
        for(int i = 0; i < ar.length ; i++){
            System.out.println(ar[i]+" ");
        }
        System.out.println();
        sortByfrequency(ar);
    }



}