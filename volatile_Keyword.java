package MultithreadingExercise;

public class volatile_Keyword implements Runnable {

        private volatile int count = 0;
        @Override
        public void run() {
            for (int i = 0; i <5 ; i++) {
                count++;
                System.out.println(count);
            }
        }

        public static void main(String[] args) {
            Thread t1=new Thread(new volatile_Keyword());
            Thread t2=new Thread(new volatile_Keyword());
            t1.start();
            t2.start();
        }
    }
