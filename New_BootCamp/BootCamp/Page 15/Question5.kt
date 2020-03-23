import java.util.*

fun main(args : Array<String>):Unit{
    var a1 : Array<Int> = arrayOf(40,41,42,43)
    var a2 : Array<Int> = arrayOf(46,45,44,43,42)

    val newArray = a1.intersect(a2.toList()).toIntArray()
    println(Arrays.toString(newArray))
}