package week11;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class CrawlerState {
    private final URL mStartingUrl;
    private final Lock visitLock = new ReentrantLock();
    private final Lock findLock = new ReentrantLock();
    private final String mNeedle;

    private Set<String> mVisitedLinks = new HashSet<>();
    private BlockingQueue<String> mToVisit = new LinkedBlockingQueue<>();
    private boolean mFound = false;

    private String mFoundUrl = "";

    public CrawlerState(URL startingUrl, String needle) {
        mStartingUrl = startingUrl;
        mNeedle = needle;
    }

    public void enqueue(String url) {
        mToVisit.offer(url);
    }

    public String dequeue() {
        String url = "";
        try {
            url = mToVisit.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return url;
    }

    public void visit(String url) {
        visitLock.lock();
        mVisitedLinks.add(url);
        visitLock.unlock();
    }

    public boolean isVisited(String url) {
        visitLock.lock();
        try {
            return mVisitedLinks.contains(url);
        } finally {
            visitLock.unlock();
        }
    }

    public void found(String url) {
        findLock.lock();
        mFound = true;
        mFoundUrl = url;
        findLock.unlock();
    }

    public synchronized String getFoundUrl() {
        findLock.lock();
        try {
            return mFoundUrl;
        } finally {
            findLock.unlock();
        }
    }

    public synchronized boolean isFound() {
        findLock.lock();
        try {
            return mFound;
        } finally {
            findLock.unlock();
        }
    }

    public URL getStartingUrl() {
        return mStartingUrl;
    }

    public String getNeedle() {
        return mNeedle;
    }
}