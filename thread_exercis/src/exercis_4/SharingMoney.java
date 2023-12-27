package exercis_4;

import java.util.Random;

public class SharingMoney implements Runnable {
    private static int totalMoney = 100;
    private static int envolope = 3;
    private static int peoples = 5;
    private static int minMoney = 1;
    private static int prize = 0;

    private static Random r = new Random();

    @Override
    public void run() {
        synchronized (SharingMoney.class){
            if(envolope == 0){
                System.out.println(Thread.currentThread().getName()+" has nothing");
            } else {
                if (envolope == 1){
                    //money in last envelope
                    prize = totalMoney;
                }else {
                    //money in second and third
                    int bounds = totalMoney - (envolope - 1)*minMoney;
                    prize = r.nextInt(bounds);
                    if(prize < minMoney) prize = minMoney;
                }
                totalMoney = totalMoney - prize;
                envolope--;
                System.out.println(Thread.currentThread().getName()+" get $"+prize);
            }

        }

    }

    public static void main(String[] args) {
        SharingMoney sm = new SharingMoney();
        for (int i = 0; i < peoples; i++) {
            Thread t = new Thread(sm,"t"+i);
            t.start();
        }
    }
}
