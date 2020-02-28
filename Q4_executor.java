package MultithreadingExercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q4_executor {

        public static void main(String[] args){

            ExecutorService executor = Executors.newFixedThreadPool(2);
            executor.submit(new OddThread());
            executor.submit(new EvenThread());
            executor.shutdownNow();

        }

    }

    class EvenThread implements Runnable{


        @Override
        public synchronized void run() {

            for(int i=1;i<=10;i++){
                if(i%2==0){
                    System.out.println("even number "+i);

                }

            }
            notify();

        }
    }


    class OddThread implements Runnable{



        @Override
        public synchronized void run() {

            for(int i=1;i<=10;i++){

                if(i%2==1){
                    System.out.println("odd number "+i);
                }
                notify();
            }
        }
    }
