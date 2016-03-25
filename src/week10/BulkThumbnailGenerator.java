package week10;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class BulkThumbnailGenerator implements Runnable {
    private String mImageExtensions = "jpggifpng";
    private String mLoadPath;
    private int mWidth;
    private int mHeight;

    public BulkThumbnailGenerator(String[] data) {
        mLoadPath = data[0];
        mWidth = Integer.parseInt(data[1]);
        mHeight = Integer.parseInt(data[2]);
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return null;
        }
    }

    @Override
    public void run() {
        File[] files = new File(mLoadPath).listFiles();
        for (File file : files) {
            String extension = getFileExtension(file);
            if (extension == null || !mImageExtensions.contains(extension)) {
                continue;
            }

            BufferedImage image = null;
            try {
                image = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String path = file.getParent() + File.separator +
                    "thumbnails" + File.separator + file.getName();

            BufferedImage resizedImage = new BufferedImage(mWidth, mHeight, image.getType());
            Graphics2D g2d = resizedImage.createGraphics();
            g2d.drawImage(image, 0, 0, mWidth, mHeight, null);
            g2d.dispose();

            File outputFile = new File(path);
            outputFile.mkdirs();

            try {
                ImageIO.write(resizedImage, extension, outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}