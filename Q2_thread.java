package MultithreadingExercise;

class Runner1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Inside thread classs in runnable "+ i);

        }

    }
}
class Runner extends Thread {
    @Override
    public void run() {
        for(int i = 0; i<10;i++){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Inside thread class "+ i);
        }
    }
}

public class Q2_thread {
    public static void main(String[] args) {
        Runner r = new Runner();
        r.start();
        Thread t1 = new Thread(new Runner());
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 10; i ++){
                    System.out.println("Inside main class " + i);
                }
            }
        });
        t1.start();
        t.start();
    }
}
