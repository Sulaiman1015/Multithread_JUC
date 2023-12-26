package exercis_7;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class LotteryMore implements Callable<List<Integer>> {
    static int boxes = 2;
    private final List<Integer> list;

    public LotteryMore(List<Integer> list) {
        this.list = new ArrayList<>(list);
    }

    @Override
    public List<Integer> call() throws InterruptedException {
        List<Integer> boxList = new ArrayList<>(6);

        while (boxList.size() < 6) { // Stop when boxList contains 6 elements
            synchronized (list) {
                if (list.isEmpty()) {
                    break;
                } else {
                    Collections.shuffle(list);
                    Integer prize = list.remove(0);
                    boxList.add(prize);
                }
            }
            Thread.sleep(10);
        }
        return boxList;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 5, 50, 100, 200, 500, 800, 2, 80, 300, 700));
        LotteryMore lottery = new LotteryMore(list);

        List<List<Integer>> allBoxLists = new ArrayList<>(); // Store all boxLists

        for (int i = 1; i <= boxes; i++) {
            FutureTask<List<Integer>> ft = new FutureTask<>(lottery);
            Thread t = new Thread(ft, "Boxes_" + i);
            t.start();
            List<Integer> boxList = ft.get();
            allBoxLists.add(boxList); // Store each boxList

            // Find and print max prize for each boxList
            Integer max = Collections.max(boxList);
            System.out.println("Boxes_" + i + " : " + boxList);
            System.out.println("Boxes_" + i + " max prize is " + max);
        }
    }
}
