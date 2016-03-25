package week09;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new BlockingQueue<>(100);

        MonitorObject monitorObject = new MonitorObject(10000);

        Thread[] producers = new Thread[10];
        for (int i = 0; i < producers.length; i++) {
            producers[i] = new Thread(new Producer(queue, monitorObject));
            producers[i].start();
        }
        Thread[] consumers = new Thread[5];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Thread(new Consumer(queue, monitorObject));
            consumers[i].start();
            consumers[i].join();
        }
    }
}
