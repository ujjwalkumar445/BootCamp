class circle (var radius : Double){
    fun area():Double{
        return Math.PI*radius*radius
    }
}

fun main(){
    fun circle.perimeter():Double{
        return 2*Math.PI*radius;
    }
    val newCircle = circle(4.8)
    println("Area of the Circle : ${newCircle.area()}")
    println("Perimeter of the circle is : ${newCircle.perimeter()}")
}