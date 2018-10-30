import org.opencv.core.*;
import org.opencv.imgcodecs.*;

public class erosion {
	/**
	 * Convert a Mat to a two-dimension int array.
	 * @param H The height of m
	 * @param W The Width of m
	 * @param m The Mat
	 * @return
	 */
	public static int[][] convert_from_mat(int H, int W, Mat m) {
		int [][] f = new int[H][W];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				f[i][j] = (int)m.get(i, j)[0];
			}
		}
		return f;
	}
	/**
	 * Convert a two-dimension int array to a Mat.
	 * @param H The height of m
	 * @param W The width of m
	 * @param image The two-dimension int array
	 * @param m The Mat
	 */
	public static void convert_to_mat(int H, int W, int[][] image, Mat m) {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				m.put(i,  j,  image[i][j]);
			}
		}
	}
	/**
	 * Perform erosion and return the result.
	 * @param H The height of f
	 * @param W The width of f
	 * @param f The original image
	 * @return The erosion result
	 */
	public static int[][] do_erosion(int H, int W, int[][] f) {
		int[][] r = new int[H][W];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				int c = 255;
				for(int x = -2; x <= 2; x++) {
					for(int y = -2; y <= 2; y++) {
						int ii = i + x;
						int jj = j + y;
						if(0 < ii && ii < H && 0 < jj & jj < W) { // if (ii, jj) is inside the image
							if(f[ii][jj] < c) {
								// find the minimum.
								c = f[ii][jj];
							}
						} else {
							c = 0;
						}
					}
				}
				r[i][j] = c;
			}
		}
		return r;
	}
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m = Imgcodecs.imread(args[0], Imgcodecs.IMREAD_GRAYSCALE);
		int H = m.height(), W = m.width();
		convert_to_mat(H, W, do_erosion(H, W, convert_from_mat(H, W, m)), m);
		Imgcodecs.imwrite(args[1], m);
	}
}