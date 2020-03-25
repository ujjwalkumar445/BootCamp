open class Bank(name : String, rot : Double){
    private var name : String
    private var rot : Double

    init {
        this.name = name
        this.rot = rot

    }

    open fun getDetails(){
        println("BankName : $name , Rate of Interest : $rot ")
    }
}

class SBI(name : String, rot :Double): Bank(name, rot){
    private var name : String
    private var rot : Double

    init {
        this.name = name
        this.rot = rot
    }

    override fun getDetails() {
        println("Bank Name : $name , Rate Of Interest : $rot")
    }
}

class BOI(name : String, rot :Double): Bank(name, rot){
    private var name : String
    private var rot : Double

    init {
        this.name = name
        this.rot = rot
    }

    override fun getDetails() {
        println("Bank Name : $name , Rate Of Interest : $rot")
    }
}

class ICICI(name : String, rot :Double): Bank(name, rot){
    private var name : String
    private var rot : Double

    init {
        this.name = name
        this.rot = rot
    }

    override fun getDetails() {
        println("Bank Name : $name , Rate Of Interest : $rot")
    }
}

fun main(args : Array<String>){
    var obj = Bank("Reserve Bank", 5.0)
    obj.getDetails()
    var sbi = SBI("SBI",4.2)
    sbi.getDetails()
    var boi = BOI("BOI",3.5)
    boi.getDetails()
    var icici = ICICI("ICICI",7.0)
    icici.getDetails()
}