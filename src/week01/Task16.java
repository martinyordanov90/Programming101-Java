package week01;

public class Task16 {
	static int[][] rescale(int[][] original, int newWidth, int newHeight) {
    	double widthRatio = newWidth / (double)original.length;
    	double heightRatio = newHeight / (double)original[0].length;
    	
    	int[][] rescale = new int[newWidth][newHeight];
    	for (int i = 0; i < rescale.length; i++) {
    		int[] sub = rescale[i];
    		for (int j = 0; j < sub.length; j++) {
    			rescale[i][j] = original[(int)(i/widthRatio)][(int)(j/heightRatio)];
    		}
    	}
    	
    	return rescale;
    }
}
