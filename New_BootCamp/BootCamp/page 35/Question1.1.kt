import java.lang.Exception

 //cLass not found
fun main(args:Array<String>) {
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver")
    } catch (e : ClassNotFoundException)
    {
        print("Exception : $e")
    }
}

