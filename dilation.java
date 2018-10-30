import org.opencv.core.*;
import org.opencv.imgcodecs.*;

public class dilation {
	public static int[][] do_dilation(int H, int W, int[][] f) {
		int[][] r = new int[H][W];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				int c = 0;
				for(int x = -2; x <= 2; x++) {
					for(int y = -2; y <= 2; y++) {
						int ii = i + x;
						int jj = j + y;
						if(0 < ii && ii < H && 0 < jj & jj < W) { // if (ii, jj) is inside the image
							if(f[ii][jj] > c) {
								// find the maximum
								c = f[ii][jj];
							}
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
		erosion.convert_to_mat(H, W, do_dilation(H, W, erosion.convert_from_mat(H, W, m)), m);
		Imgcodecs.imwrite(args[1], m);
	}
}