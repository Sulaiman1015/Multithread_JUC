package producer_consumer;

import javafx.scene.control.Tab;

public class Foodie extends Thread {
    @Override
    public void run() {
        while (true){
            synchronized (Table.lock){
                if ( Table.bowls == 0 ){
                    break;
                }else {
                    if ( Table.foodFlag == 0){
                        try {
                            Table.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        Table.bowls--;
                        System.out.println("there left "+ Table.bowls +" bowls");
                        Table.lock.notifyAll();
                        Table.foodFlag = 0;
                    }
                }
            }
        }
    }
}
