import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	public void keepOnlyBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {
				count++;
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
		System.out.println("Count is " + count);
	}

	public void negate() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				int newRed = 255 - pixelObj.getRed();
				int newBlue = 255 - pixelObj.getBlue();
				int newGreen = 255 - pixelObj.getGreen();
				pixelObj.setRed(newRed);
				pixelObj.setBlue(newBlue);
				pixelObj.setGreen(newGreen);
			}
		}
	}

	public void grayscale() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel [] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				int avg = (pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen()) / 3;
				pixelObj.setRed(avg);
				pixelObj.setBlue(avg);
				pixelObj.setGreen(avg);
			}
		}
	}

	public void fixUnderwater() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel [] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				int newGreen = pixelObj.getGreen() - 100;
				int newBlue = pixelObj.getBlue() - 100;
				pixelObj.setGreen(newGreen);
				pixelObj.setBlue(newBlue);
			}
		}
	}

	public void mirrorVerticalRightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel botPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height/2; row++) {
			for (int col = 0; col < pixels[row].length; col++) {
				topPixel = pixels[row][col];
				botPixel = pixels[height - 1 - row][col];
				botPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorHorizontalBotToTop() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel botPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height/2; row++) {
			for (int col = 0; col < pixels[row].length; col++) {
				topPixel = pixels[row][col];
				botPixel = pixels[height - 1 - row][col];
				topPixel.setColor(botPixel.getColor());
			}
		}
	}

	public void mirrorDiagonal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel botLeftPixel = null;
		Pixel topRightPixel = null;
		int length = pixels.length;
		if (pixels.length > pixels[0].length) {
			length = pixels[0].length;
		}
		for (int row = 0; row < length; row++) {
			for (int col = 0; col < row; col++) {
				botLeftPixel = pixels[row][col];
				topRightPixel = pixels[col][row];
				topRightPixel.setColor(botLeftPixel.getColor());
			}
		}		
	}

	public void mirrorArms() {
		Pixel[][] pixels = this.getPixels2D();
		int mirrorPoint = 194;
		Pixel topPixel = null;
		Pixel botPixel = null;
		for (int row = 159; row < mirrorPoint; row++) {
			for (int col = 105; col < 293; col++) {
				topPixel = pixels[row][col];
				botPixel = pixels[mirrorPoint - row + mirrorPoint][col];
				botPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorGull() {
		Pixel[][] pixels = this.getPixels2D();
		int mirrorPoint = 350;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		for (int row = 230; row <= 335; row++) {
			for (int col = 230; col < mirrorPoint; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	public void copyPart(Picture fromPic, int startInPicRow, int endInPicRow, int startInPicCol, int endInPicCol, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = startInPicRow, toRow = startRow; fromRow < endInPicRow
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = startInPicCol, toCol = startCol; fromCol < endInPicCol
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */
	public void createCollage() {
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}

	public void myCollage() {
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		Picture flowerNoBlue = new Picture(flower1);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 200, 0);
		flower1.mirrorDiagonal();
		flower2.negate();
		this.copy(flower1, 300, 0);
		this.copy(flower2, 400, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel topPixel = null;
		Pixel botPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		Color botColor = null;
		for (int row = 0; row < pixels.length - 1; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				topPixel = pixels[row][col];
				botPixel = pixels[row + 1][col];
				rightColor = rightPixel.getColor();
				botColor = botPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist || topPixel.colorDistance(botColor) > edgeDist) {
					leftPixel.setColor(Color.BLACK);
				}
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args) {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

} // this } is the end of class Picture, put all new methods before this
