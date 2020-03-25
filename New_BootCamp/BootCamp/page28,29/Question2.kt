class op{

    fun operation1(num1 : Int,num2 : Int){
        println("$num1 + $num2 = ${num1+num2}")
    }
    fun operation1(num1 : Double, num2 : Double){
        println("$num1 + $num2 = ${num1+num2}")
    }
    fun operation2(num1 : Int, num2 : Int){
        println("$num1 * $num2 = ${num1*num2}")
    }
    fun operation3(s1 : String, s2 : String){
        println(s1 + " " + s2)
    }
    fun operation3(s1 :String,s2 :String,s3 : String){
        println(s1 + " " + s2 + " " + s3)
    }

}

fun main(args:Array<String> ){
    var obj = op()
    obj.operation1(87,6)
    obj.operation1(10.0,7.8)
    obj.operation2(5,9)
    obj.operation3("Hello","World")
    obj.operation3("Hello","to","everyone")
}


