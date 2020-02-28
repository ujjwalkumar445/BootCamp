package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
    int age,score;
    String name;

    public Student(int age, String name, int score){
        this.age=age;
        this.name=name;
        this.score=score;
    }
    //used to print detail in main()
    public String toString()
    {
        return "age = "+this.age+" name = "+this.name+" score : "+this.score;
    }
}

class SortbyScore implements Comparator<Student>
{

    public int compare(Student a, Student b)
    {
        if(b.score!=a.score)
            return b.score - a.score;
        else
        {
            return a.name.compareTo(b.name);
        }
    }
}

class Q6_student {
    public static void main(String[] args) {
        ArrayList<Student> ar = new ArrayList<Student>();
        ar.add(new Student(20, "ujjwal1", 100));
        ar.add(new Student(30, "john", 60));
        ar.add(new Student(30, "aman", 60));
        ar.add(new Student(40, "vibhav", 80));

        System.out.println("Unsorted");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        Collections.sort(ar, new SortbyScore());

        System.out.println("\nSorted by score");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

    }
}
