import java.awt.Color;

public class Steganography {

	public static void main(String[] args) {
		Picture arch = new Picture("arch.jpg");
		Picture beach = new Picture("beach.jpg");
		Picture blueCycle = new Picture("blueMotorcycle.jpg");
		
		/* Activity 1 */
		Picture copy = testSetLow(beach, Color.PINK);
		copy = testClearLow(beach);
		Picture copy2 = revealPicture(copy);
		
		/* Activity 2 */
		System.out.println(canHide(beach, blueCycle));
		System.out.println(canHide(beach, arch));
		
		Picture test = hidePicture(beach, blueCycle);
		
		beach.explore();
		// copy2.explore();
		test.explore();
	}

	/**
	 * Clear the lower (rightmost) two bits in a pixel.
	 */
	public static void clearLow(Pixel p) {
		p.setRed((p.getRed() / 4) * 4);
		p.setBlue((p.getBlue() / 4) * 4);
		p.setGreen((p.getGreen() / 4) * 4);
	}

	public static Picture testClearLow(Picture pic) {
		Picture copy = new Picture(pic);
		for (int i = 0; i < copy.getHeight(); i++) {
			for (int j = 0; j < copy.getWidth(); j++) {
				clearLow(copy.getPixel(j, i));
			}
		}

		return copy;
	}

	/**
	 * Set the lower (rightmost) two bits in a pixel.
	 */
	public static void setLow(Pixel p, Color c) {
		clearLow(p);
		p.setRed(p.getRed() + (c.getRed() / 64));
		p.setBlue(p.getBlue() + (c.getBlue() / 64));
		p.setGreen(p.getGreen() + (c.getGreen() / 64));
	}

	public static Picture testSetLow(Picture pic, Color c) {
		Picture copy = new Picture(pic);
		for (int i = 0; i < copy.getHeight(); i++) {
			for (int j = 0; j < copy.getWidth(); j++) {
				setLow(copy.getPixel(j, i), c);
			}
		}
		return copy;
	}

	/**
	 * Sets the highest two bits of each pixel’s colors to the lowest two bits of
	 * each pixel’s colors
	 */
	public static Picture revealPicture(Picture hidden) {
		Picture copy = new Picture(hidden);
		Pixel[][] pixels = copy.getPixels2D();
		Pixel[][] source = hidden.getPixels2D();
		for (int r = 0; r < pixels.length; r++) {
			for (int c = 0; c < pixels[0].length; c++) {
				Color col = source[r][c].getColor();
				pixels[r][c].setRed(pixels[r][c].getRed() % 64 + col.getRed() % 4 * 64);
				pixels[r][c].setBlue(pixels[r][c].getBlue() % 64 + col.getBlue() % 4 * 64);
				pixels[r][c].setGreen(pixels[r][c].getGreen() % 64 + col.getGreen() % 4 * 64);
			}
		}
		return copy;
	}
	
	/**
	 * Determines whether secret can be hidden in source, which is
	 * true if source and secret are the same dimensions.
	 * @param source is not null
	 * @param secret is not null
	 * @return true if secret can be hidden in source, false otherwise.
	 */
	public static boolean canHide(Picture source, Picture secret) {
		return source.getHeight() == secret.getHeight() && source.getWidth() == secret.getWidth();
	}
	
	/**
	 * Creates a new Picture with data from secret hidden in data from source
	 * @param source is not null
	 * @param secret is not null
	 * @return combined Picture with secret hidden in source
	 * precondition: source is same width and height as secret
	 */
	public static Picture hidePicture(Picture source, Picture secret) {
		if (!canHide(source, secret)) {
			return null;
		}
		
		Picture s = new Picture(source);
		
		Pixel[][] sPix = s.getPixels2D();
		Pixel[][] cPix = secret.getPixels2D();
		for (int r = 0; r < sPix.length; r++) {
			for (int c = 0; c < sPix.length; c++) {
				setLow(sPix[r][c], cPix[r][c].getColor());
			}
		}
		
		return s;
	}

}
