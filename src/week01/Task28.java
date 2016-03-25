package week01;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Task28 {
	static void convertToGreyscale(String imgpath) {
    	try {
    		BufferedImage img = ImageIO.read(new File(imgpath));
    		int w = img.getWidth();
    		int h = img.getHeight();
    		for (int i = 0; i < w; i++) {
    			for (int j = 0; j < h; j++) {
    				Color pixel = new Color(img.getRGB(i, j));
    				int red = pixel.getRed();
    			    int green = pixel.getGreen();
    			    int blue = pixel.getBlue();
    				int gray = (red + green + blue) / 3;
    				int alpha = pixel.getAlpha();
    				Color grayPixel = new Color(gray, gray, gray, alpha);
    				img.setRGB(i, j, grayPixel.getRGB());
    			}
    		}
    		String fileExtension = Arrays.stream(imgpath.split("\\."))
    				                     .reduce((prev, curr) -> curr)
    				                     .get()
    				                     .toUpperCase();
    		ImageIO.write(img, fileExtension, new File(imgpath));
    	} catch (IOException ex) {
    		System.err.println(ex);
    		return;
    	}
    }
}
