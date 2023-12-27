package exercis_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lottery implements Runnable{
    static int boxes = 2;
    //static ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 5, 50, 100, 200, 800, 2, 80, 300, 700));
    static final List<Integer> list = Collections.synchronizedList(new ArrayList<>(Arrays.asList(10, 5, 50, 100, 200, 800, 2, 80, 300, 700)));

    @Override
    public void run() {
        while (true){
            synchronized (list){//Lottery.class
                if(list.isEmpty()){
                    break;
                }else {
                    Collections.shuffle(list);
                    Integer prize = list.remove(0);
                    System.out.println(Thread.currentThread().getName()+" got prize "+prize);
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        for (int i = 1; i <= boxes; i++) {
            Thread t = new Thread(lottery, "Boxes_"+i);
            t.start();
        }
    }
}
