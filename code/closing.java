import org.opencv.core.*;
import org.opencv.imgcodecs.*;

public class closing {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m = Imgcodecs.imread(args[0], Imgcodecs.IMREAD_GRAYSCALE);
		int H = m.height(), W = m.width();
		// closing: dilation operation followed by an erosion operation 
		erosion.convert_to_mat(
				H,
				W,
				erosion.do_erosion(
						H,
						W,
						dilation.do_dilation(
								H,
								W,
								erosion.convert_from_mat(H, W, m))),
				m);
		Imgcodecs.imwrite(args[1], m);
	}
}
