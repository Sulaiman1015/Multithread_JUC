package producer_consumer;

public class Cook extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (Table.lock){
                if ( Table.bowls == 0){
                    break;
                } else {
                    if ( Table.foodFlag == 1){
                        try {
                            Table.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        System.out.println("Cook made a bowl of food and put it on the table");
                        Table.foodFlag = 1;
                        Table.lock.notifyAll();
                    }
                }
            }
        }
    }
}
