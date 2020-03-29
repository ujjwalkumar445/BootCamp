fun main(args:Array<String>){
    println("enter String")
    var s1= readLine()!!.toString()
    var words = s1.split(" ").toTypedArray()
    var count =0
    for (i in 0 until words.size) {
        count = 1
        for (j in i + 1 until words.size) {
            if (words[i].equals(words[j])) {
                count++
                words[j] = "0"
            }
        }
        if (count > 1 && (words[i] != "0")) {
            println(words[i] + ":" + count)
        }
    }
}



