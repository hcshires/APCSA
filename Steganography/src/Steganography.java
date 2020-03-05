import java.awt.Color;

public class Steganography {

	public static void main(String[] args) {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		Picture copy = testSetLow(beach, Color.PINK);
		// copy = testClearLow(beach);
		Picture copy2 = revealPicture(copy);
		copy2.explore();
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
				Pixel p = copy.getPixel(j, i);
				setLow(p, c);
			}
		}
		return copy;
	}

	/**
	 * Sets the highest two bits of each pixel’s colors to the lowest two bits of
	 * each pixel’s color o s
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

}
