# Digital-image
Use Java OpenCV to read image, access image pixels, and write image with mathematical morphology such as erosion, dilation, opening and closing

• Main Principles
The morphology in digital image processing is closely allied to the mathematical Set Theory
 For instance, typically there are only two values for each pixel in binary image. Numerically, the two values are often 0 for black, and either 1 or 255 for white. (Web.archive.org, 2018)
All of coordinate collection of white pixels can be used for an image, and the processing of
erosion, dilation, opening and closing is based on mathematical morphology. Moreover,
we may also designate any images that have only one sample per pixel, such as grayscale
images.
(Graphics.com, 2018) Basically
, the maximum of light intensity can be taken by
using union of sets in binary image in the corresponding grayscale. On the other hand, the
minimum of light intensity can be taken by using intersection of sets in binary image
 to correspond tograyscale.

I.
• Three Selected Algorithms Boundary Extraction
β(A) = A - (A ⊖ B)
We can set erosion to find the boundary of an image. If we set the erosion of A by B, then can get all of structuring element of the A that can be put. In other words, it means that
. (Gonzalez and Woods, 2002)
II. Extraction of Connected Components
Xk = (X{k-1} ⊕ B) ∩ A
The procedure can be stop when Xk = X{k-1}, with X0 containing the initial point of connected components. Furthermore, we continually use dilation and intersect to find the white coordinate which is close to the current point. In this way, we can find all of coordinates that can be passed as long as A (white pixels) by the initial point.
III. Hole Filling
 coordinate points
 B is completely contained by A the pixel is retained, else deleted. The boundary
 of A can be gotten if we continually eroded
 The algorithm of extraction of connected components is to start with X0 and find all the connected components step by step.
Xk = (X{k-1} ⊕ B) ∩ A^C
The algorithm of hole filling is similar to extraction of connected components. There is a significant difference when calculating intersection with A^C (black pixels) rather than A (white pixels). Therefore, all of coordinates can be passed as long as A^C (black pixels) by the initial point.
• Three Selected Applications
I. Noise Removal
If there is noise removal in an image, we can set an opening operation which followed by a closing operation can remove the noise. (Internationaljournalssrg.org, 2018)
II. Image Compression
We can use morphology to eliminate some unimportant points in an image when we process the lossy image compression, then can get a small size image compared to the original image.
III. Fingerprint Feature Extraction
• References
It is important to capture useful features when we process machine learning or image recognition.
Moreover, ridge ending and ridge bifurcation are necessary for processing fingerprint recognition. We can use some patterns such as thinning, spikes removing and dots removing to help to get the features we need.
 Web.archive.org. (2018). Conversion of a Color Image to a Binary Image. [online] Available
 at:
 https://web.archive.org/web/20080610170124/http:/www.codersource.net/csharp_color_imag
 e_to_binary.aspx [Accessed 19 Jan. 2018].
 Graphics.com. (2018). Photoshop Fundamentals: Working in Different Color Modes. [online]
 Available at: http://www.graphics.com/article-old/photoshop-fundamentals-working-
 different-color-modes [Accessed 19 Jan. 2018].
 Gonzalez, R. and Woods, R. (2002). Digital image processing. Upper Saddle River, N.J.:
 Prentice Hall.
 Internationaljournalssrg.org. (2018). Cite a Website - Cite This For Me. [online] Available at:
 http://www.internationaljournalssrg.org/IJECE/2016/Volume3-Issue8/IJECE-V3I8P128.pdf
 [Accessed 19 Jan. 2018].
 Ijser.in. (2018). Cite a Website - Cite This For Me. [online] Available at:
 http://www.ijser.in/archives/v2i4/SjIwMTMyMzA=.pdf [Accessed 19 Jan. 2018].
Iject.org. (2018). Cite a Website - Cite This For Me. [online] Available at: http://www.iject.org/vol4/spl3/c0096.pdf [Accessed 19 Jan. 2018].
