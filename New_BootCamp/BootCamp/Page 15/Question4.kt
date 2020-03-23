fun main(args: Array<String>): Unit{
    var s1 = "Ujjwal@2020"
    var count : Array<Int> = arrayOf(0,0,0,0)
    var ch = s1.toCharArray()
    for(i in ch){
        var n = i.toInt()
        if(n>=48 && n<=57) count[0]++;
        else if(n>=65 && n<=90) count[1]++;
        else if(n>=97 && n<=122) count[2]++;
        else count[3]++;

    }
    println("Number of digits $s1 is ${count[0]} which is "
    +(count[0]*100.0/s1.length)+"%");
    println("Number of Upper case in $s1 is ${count[1]} which is "
            + (count[1]*100.0/s1.length) + " %");
    println("Number of Lower case in $s1 is ${count[2]} which is "
            + (count[2]*100.0/s1.length) + " %");
    println("Number of Special Characters in $s1 is ${count[3]} which is"
    +(count[3]*100.0/s1.length)+ "%");
}