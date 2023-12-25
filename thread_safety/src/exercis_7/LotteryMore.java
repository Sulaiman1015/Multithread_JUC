package exercis_7;

import java.util.*;
import java.util.concurrent.Callable;

public class LotteryMore implements Callable<Integer> {
    static int boxes = 2;
    static final ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 5, 50, 100, 200, 500, 800, 2, 80, 300, 700));

    @Override
    public Integer call() throws Exception {
        ArrayList<Integer> boxList = new ArrayList<>(6);
        while (true){
            synchronized (LotteryMore.class){
                if(list.size() == 0){
                    System.out.println(Thread.currentThread().getName()+": "+boxList);
                }else {
                    Collections.shuffle(list);
                    Integer prize = list.remove(0);
                    boxList.add(prize);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LotteryMore lottery = new LotteryMore();
        for (int i = 1; i <= boxes; i++) {

        }
    }

}
