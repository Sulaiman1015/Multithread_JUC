package exercis_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LotteryPlus implements Runnable{
    static int boxes = 2;
    static final List<Integer> list = new ArrayList<>(Arrays.asList(10, 5, 50, 100, 200, 800, 2, 80, 300, 700));

    @Override
    public void run() {
        List<Integer> listBox = new ArrayList<>();
        while (true){
            synchronized (LotteryPlus.class){
                if(list.isEmpty()){
                    System.out.println(Thread.currentThread().getName()+": "+listBox);
                    break;
                }else {
                    Collections.shuffle(list);
                    Integer prize = list.remove(0);
                    listBox.add(prize);
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
        LotteryPlus lottery = new LotteryPlus();
        for (int i = 1; i <= boxes; i++) {
            Thread t = new Thread(lottery, "Boxes_"+i);
            t.start();
        }
    }
}
