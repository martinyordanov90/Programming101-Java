package week10;

public class ThumbnailGen {
    public static void main(String[] args) {
        Thread thread = new Thread(new BulkThumbnailGenerator(args));
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
