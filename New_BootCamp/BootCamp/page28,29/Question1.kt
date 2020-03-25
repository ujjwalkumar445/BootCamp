class ABC(FirstName : String,LastName : String){
    val FirstName : String
    val LastName :String

    //companion object
    companion object {
        const val  age : Int = 22
    }
    init {
        this.FirstName = FirstName
        this.LastName = LastName
    }
}
fun main(args:Array<String>) {
    var person = ABC("Ujjwal","Kumar")
    println("The ${person.FirstName} ${person.LastName} is ${ABC.Companion.age} year old")
}
