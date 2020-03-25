fun grade(marks : Double):String{
    var marks = Math.round(marks)
    return when(marks){
        in 0..50 -> "fail"
        in 50..60 -> "Good"
        in 60..70 -> "Very Good"
        in 70..80 -> "Excellent"
        in 80..100 -> "Extra Ordinary"
        else -> "Invaild marks"
    }
}

fun main (args:Array<String>){
    println("Grade : ${grade(70.0)}")
}