package collection;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employee {
    int age,salary;
    String name;

    //Constructor
    public Employee(int age, String name, int salary)
    {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }
    //Used to print student details in main()
    public String toString()
    {
        return "age = "+this.age + " name = " + this.name + "salary" +this.salary;
    }
}

class SortbySalary implements Comparator<Employee>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Employee a, Employee b)
    {
        if(b.salary>a.salary)
            return 1;
        else
            return -1;
    }
}

class Q5_employee {
    public static void main(String[] args) {
        ArrayList<Employee> ar = new ArrayList<Employee>();
        ar.add(new Employee(20, "ujjwal1", 10000));
        ar.add(new Employee(30, "ujjwal2", 30000));
        ar.add(new Employee(40, "ujjwal3", 20000));

        System.out.println("Unsorted");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        Collections.sort(ar, new SortbySalary());

        System.out.println("\nSorted by salary");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));


    }
    }
