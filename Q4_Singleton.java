package exercise2;

class Q4_Singleton {
    private static Q4_Singleton obj;

    static {
        obj = new Q4_Singleton();
    }
    private Q4_Singleton(){

    }
    public static Q4_Singleton getInstance() {
        return obj;
    }
    public void func(){
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Q4_Singleton sgn = getInstance();
        sgn.func();
    }
}
