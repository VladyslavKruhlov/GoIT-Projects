 public class PrintTime extends Thread {
     public static int count = 5;

     @Override
     public void run() {
             while (true){
                 try {
                     PrintTime.sleep(5000);
                 System.out.println("Минуло " + count + " секунд");
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
             count += 5;
             }
     }
    }
