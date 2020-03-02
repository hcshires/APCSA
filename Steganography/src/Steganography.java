import java.awt.Color;

public class Steganography {

	public static void main(String[] args) {
		Picture beach = new Picture ("beach.jpg");
		beach.explore();
		Picture copy = testClearLow(beach);
		copy.explore();
	}
	
	/**
	 * Clear the lower (rightmost) two bits in a pixel.
	 */
	public static void clearLow(Pixel p) {
		p.setRed((p.getRed() / 4) * 4);
		p.setBlue((p.getBlue() / 4) * 4);
		p.setGreen((p.getRed() / 4) * 4);
	}
	
	public static Picture testClearLow(Picture pic) {
		for (int i = 0; i < pic.getHeight(); i++) {
			for (int j = 0; j < pic.getWidth(); j++) {
				clearLow(pic.getPixel(j, i));
			}
		}
		
		return pic;
	}

}
