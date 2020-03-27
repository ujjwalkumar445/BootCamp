import com.sun.tracing.dtrace.ArgsAttributes

class Employee(name :String, age : Int) {
    val name : String
    val age : Int
    init {
        this.name = name
        this.age = age
    }
}

fun main(args : Array<String>){
    var emlist = mutableListOf<Employee>(
        Employee("ujjwal",22),
        Employee("Bharat",33),
        Employee("Anupam",44),
        Employee("Ashutosh",11)
    )

    var list = emlist.filter{i -> i.age > 30}

    for (employee in list){
        println("Employee Name : ${employee.name}, Age : ${employee.age}")
    }
}