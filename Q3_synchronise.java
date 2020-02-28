package MultithreadingExercise;

public class Q3_synchronise extends Thread {
    public int count = 0;

    @Override
    public void run() {
        for(int i = 0; i<10; i++){
            System.out.println("Inside thread class using synchronized method "+i);
            incrementCount();
            synchronizedBlock();
        }
        System.out.println("count=="+count);
    }
    private synchronized void incrementCount() {
        count++;
    }
    private void synchronizedBlock(){
        synchronized (this){
            count++;
        }
    }

    public static void main(String[] args) {
        Q3_synchronise sync = new Q3_synchronise();
        Q3_synchronise sync1 = new Q3_synchronise();
        sync.start();
        sync1.start();
    }
}
