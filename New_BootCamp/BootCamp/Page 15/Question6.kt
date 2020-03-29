fun main(args : Array<String>){
    println("Enter String")
    var s1 = readLine()!!.toString()
    var ch = s1.toCharArray()

    for (i in 0 until s1.length){
        for (j in i+1 until s1.length){
            if (ch[i]==ch[j]){
                ch[i]='*'
                ch[j]='*'
            }
        }
    }
    for (i in 0 until ch.size){
        if (ch[i] != '*'){
            println(ch[i])
        }
    }
}