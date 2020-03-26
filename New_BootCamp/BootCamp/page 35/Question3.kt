sealed class Base{
    class A : Base()
    class B : Base()
    class C : Base()

}

fun obj(base : Base): String {
    return when(base){
        is Base.A -> "A"
        is Base.B -> "B"
        is Base.C -> "C"
    }
}

fun main (args : Array<String>){
    println("Class Name : ${obj(Base.A())}")
    println("Class Name : ${obj(Base.B())}")
    println("Class Name : ${obj(Base.C())}")
}