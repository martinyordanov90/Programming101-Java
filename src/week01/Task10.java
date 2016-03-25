package week01;

public class Task10 {
	static int[] histogram(short[][] image) {
        int[] result = new int[255];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                result[image[i][j]]++;
            }
        }
        return result;
    }
}
