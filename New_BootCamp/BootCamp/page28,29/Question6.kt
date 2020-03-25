fun main(args: Array<String>){
    var list = mutableListOf<Int>(23,45,67,89,56)
    println("List Before : $list")

    list[1]=78
    println("List After : $list")
}