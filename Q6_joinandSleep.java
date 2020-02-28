package MultithreadingExercise;

import exercise2.Q6;

public class Q6_joinandSleep extends Thread {

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Q6_joinandSleep t1 = new Q6_joinandSleep();
        Q6_joinandSleep t2 = new Q6_joinandSleep();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        t2.start();
    }
}
