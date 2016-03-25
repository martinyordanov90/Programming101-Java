package week09;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by plamen on 1/28/16.
 *
 * Bonus task has been implemented as a test on this class
 */
public class BlockingQueue<T> {

    private Queue<T> mQueue;
    private AtomicInteger mCapacity;

    private final Object mProducerLock = new Object();
    private final Object mConsumerLock = new Object();

    public BlockingQueue(int capacity) {
        mQueue = new LinkedList<>();
        mCapacity = new AtomicInteger(capacity);
    }

    public synchronized void add(T item) {
        mQueue.add(item);
    }

    public synchronized T remove() {
        return mQueue.remove();
    }

    public void offer(T item) throws InterruptedException {
        synchronized (mProducerLock) {
            while (mQueue.size() == mCapacity.get()) {
                mProducerLock.wait();
            }
            mQueue.add(item);
        }
        synchronized (mConsumerLock) {
            mConsumerLock.notifyAll();
        }
    }

    public T poll() throws InterruptedException {
        synchronized (mConsumerLock) {
            while (mQueue.size() == 0) {
                mConsumerLock.wait();
            }
        }
        synchronized (mProducerLock) {
            try {
                return mQueue.remove();
            } finally {
                mProducerLock.notifyAll();
            }
        }
    }

    public synchronized int size() {
        return mQueue.size();
    }
}