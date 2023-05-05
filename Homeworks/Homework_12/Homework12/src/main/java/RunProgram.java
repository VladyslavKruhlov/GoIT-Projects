

public class RunProgram extends Thread {
    public static int count=0;

    @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
                if (count != 1) {
                    System.out.println(count + " seconds");
                }
                else {
                    System.out.println(count + " second");
                    }
                }
            }
        }
