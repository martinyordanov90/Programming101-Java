package week09;

import java.util.concurrent.atomic.AtomicInteger;


public class Consumer implements Runnable {
    private BlockingQueue<Integer> mQueue;
    private MonitorObject mMonitorObj;

    public Consumer(BlockingQueue<Integer> queue, MonitorObject monitorObj) {
        mQueue = queue;
        mMonitorObj = monitorObj;
    }

    @Override
    public void run() {
        while (mMonitorObj.shouldConsume()) {
            try {
                System.out.println(mQueue.poll());
                mMonitorObj.consume();
            } catch (InterruptedException e) {
                System.out.println("Interrupted consumer.");
            }
        }
        System.out.println("FINISHED CONSUMING: " + Thread.currentThread().getName());
    }
}