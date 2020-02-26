package exercise2;

public class Q13_Exception extends Exception {
    private String message ;

    public Q13_Exception(String message) {
        this.message= message;

    }
    @Override
    public String getMessage() {
        return message;
    }
}
class Exception1
{
    public String findname(int id)throws Q13_Exception
    {
        if(id==100)
        {
            throw new Q13_Exception("wrong id is given Exception");
        }
        return "welcome";
    }
    public static void main(String[] args) throws Q13_Exception  {
        Exception1 exception = new Exception1();
        exception.findname(100);
    }
}
