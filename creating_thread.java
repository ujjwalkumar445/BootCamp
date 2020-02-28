package MultithreadingExercise;

public class creating_thread extends Thread {
    public void run()
    {
        System.out.println("Run method executed by child thread");
    }

    public static void main(String[] args) {
        creating_thread t = new creating_thread();
        t.start();
        System.out.println("main method executed");
    }
}
