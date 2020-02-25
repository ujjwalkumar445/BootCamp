package collection;

import java.util.*;

public class Q4_sort {
    public static void main(String[] args) {
        HashMap<String, Integer> h1 = new HashMap<String, Integer>();
        h1.put("ujjwal", 1);
        h1.put("prashant",5);
        h1.put("aman", 3);

        //create a list from element in HashMap

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(h1.entrySet());

        //sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        //put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for(Map.Entry<String,Integer> aa : list){
            temp.put(aa.getKey(), aa.getValue());
        }
        System.out.println(temp);
    }
}
