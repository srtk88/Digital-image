import org.opencv.core.*;
import org.opencv.imgcodecs.*;

public class opening {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m = Imgcodecs.imread(args[0], Imgcodecs.IMREAD_GRAYSCALE);
		int H = m.height(), W = m.width();
		// opening: dilation after erosion
		erosion.convert_to_mat(
				H,
				W,
				dilation.do_dilation(
						H,
						W,
						erosion.do_erosion(
								H,
								W,
								erosion.convert_from_mat(H, W, m))),
				m);
		Imgcodecs.imwrite(args[1], m);
	}
}