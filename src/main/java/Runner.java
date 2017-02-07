import java.lang.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class Runner extends Thread
{
    static Semaphore semaphore = new Semaphore(1);
    int counter = 0;
    String name;

    public Runner(String name){
        this.name = name;
    }

    public void run()
    {
        for (int i = 0; i<10; i++){

            if (this.name.equalsIgnoreCase("Ann")){
                // do something here, eg. semaphore.acquire();
            }

            if (this.name.equalsIgnoreCase("Bill")){
                // do something here
            }

            if (this.name.equalsIgnoreCase("Charlie")){
                // do something here
            }

            // let's run a lap!
            this.counter++;
            System.out.println(this.name + " " + this.counter);

            try {
                // let's slow everyone down a bit
                Thread.sleep(500);

                // let's make bill a bit slower than anyone else to see the results
                if (this.name.equalsIgnoreCase("Bill")){
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        // runner finished!
        System.out.println(this.name + " finished!");
    }
}