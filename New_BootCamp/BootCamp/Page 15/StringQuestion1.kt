fun main(args: Array<String>): Unit {
    var a : String = "Hello Everyone"
    println("Before replace : $a")
    var b : String = "World"
    b = a.replace("Everyone",b)
    print(b)
}