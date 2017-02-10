import java.lang.*;
import java.util.concurrent.Semaphore;

public class Car extends Thread {
    public static Semaphore east = new Semaphore(1, false);
    public static Semaphore west = new Semaphore(1, false);
    public static Semaphore bridgeEmpty = new Semaphore(1, false);
    public static int counterEast;
    public static int counterWest;


    public void run() {

        try {
            for (int i = 0; i<10; i++){
                enter_bridge_east();
                exit_bridge_east();
                Thread.sleep(5);
                enter_bridge_west();
                exit_bridge_west();
                Thread.sleep(5);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void enter_bridge_east() throws InterruptedException {
        east.acquire();
        counterEast++;
        if(counterEast == 1){
            System.out.println("<--- GOING EAST");
            bridgeEmpty.acquire();
        }
        System.out.println("<--- " + this.getName());
        east.release();
    }

    public void exit_bridge_east() throws InterruptedException {
        east.acquire();
        counterEast--;
        System.out.println("|--- " + this.getName());
        if (counterEast == 0){
            bridgeEmpty.release();
            System.out.println("-----------");
        }
        east.release();
    }

    public void enter_bridge_west() throws InterruptedException {
        west.acquire();
        counterWest++;
        if(counterWest == 1){
            bridgeEmpty.acquire();
            System.out.println("GOING WEST --->");
        }
        System.out.println(this.getName() + " --->");
        west.release();
    }

    public void exit_bridge_west() throws InterruptedException {
        west.acquire();
        counterWest--;
        System.out.println(this.getName() +" ---|");
        if (counterWest == 0){
            bridgeEmpty.release();
            System.out.println("-----------");
        }
        west.release();
    }
}