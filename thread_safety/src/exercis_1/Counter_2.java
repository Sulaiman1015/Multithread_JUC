package exercis_1;

public class Counter_2 extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (Counter_2.class){
                if ( Center.tickets == 0){
                    break;
                }else {
                    Center.tickets--;
                    System.out.println("left "+Center.tickets+" tickets");
                }
            }
        }
    }
}
