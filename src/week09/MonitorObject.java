package week09;

import java.util.concurrent.atomic.AtomicInteger;


public class MonitorObject {
    private final int mToProduce;
    private AtomicInteger mProduced = new AtomicInteger(0);
    private AtomicInteger mConsumed = new AtomicInteger(0);

    private final Object producerLock = new Object();
    private final Object consumerLock = new Object();

    public MonitorObject(int toProduce) {
        mToProduce = toProduce;
    }

    public boolean shouldProduce() {
        synchronized (producerLock) {
            return mProduced.get() < mToProduce;
        }
    }

    public boolean shouldConsume() {
        synchronized (consumerLock) {
            return mConsumed.get() < mToProduce;
        }
    }

    public void produce() {
        synchronized (producerLock) {
            mProduced.incrementAndGet();
        }
    }

    public void consume() {
        synchronized (consumerLock) {
            mConsumed.incrementAndGet();
        }
    }
}