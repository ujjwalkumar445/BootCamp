package exercise2;

public class Q6 {

    public static void main(String[] args) {

        try {

            int num = 100/0;
            System.out.println(num);
        } catch (ArithmeticException e){
            System.out.println("Number should not divided by zero");
        }

        finally{
            System.out.println("This is the finally block");
        }
        System.out.println("out of try-catch-final");
    }
}
