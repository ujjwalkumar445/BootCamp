fun main(args:Array<String>){
    var map = mutableMapOf<Int,String>(1 to "Ujjwal", 2 to "Aman",3 to "Rajat")
    for (i in map){
        println("Key : ${i.key}, Value : ${i.value}")
    }
}