import th.in.mas.thanawat.cases.MergeOperation;
import th.in.mas.thanawat.cases.ZipOperation;

import java.util.concurrent.TimeUnit;

public class Experiment {

    private static final long WAIT_TIME = TimeUnit.SECONDS.toMillis(1);

    private static void wait1Seconds() {
        try {
            Thread.sleep(WAIT_TIME);
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MergeOperation mergeOperation = new MergeOperation();
        ZipOperation zipOperation = new ZipOperation();
        try {
            mergeOperation.runSmoothAtSilk();
        } catch (Exception e) {
            e.printStackTrace();
        }
        wait1Seconds();

        try {
            zipOperation.runSmoothAtSilk();
        } catch (Exception e) {
            e.printStackTrace();
        }
        wait1Seconds();

        try {
            mergeOperation.runStickWithProblem();
        } catch (Exception e) {
            e.printStackTrace();
        }
        wait1Seconds();

        try {
            zipOperation.runStickWithProblem();
        } catch (Exception e) {
            e.printStackTrace();
        }
        wait1Seconds();
    }
}
