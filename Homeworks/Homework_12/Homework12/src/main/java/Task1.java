
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task1 {

    public static void main(String[] args) throws InterruptedException {
        RunProgram run = new RunProgram();
        PrintTime print = new PrintTime();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.schedule(
          new RunProgram(),
          1,
          TimeUnit.SECONDS
          );
        ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(1);
        executor.schedule(
                new PrintTime(),
                5,
                TimeUnit.SECONDS
        );
//        run.start();
//        print.start();
    }
}
