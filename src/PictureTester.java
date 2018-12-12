/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  public static void testNegate() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }

  public static void testGrayscale() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.grayscale();
    beach.explore();
  }

  public static void testFixUnderwater() {
    Picture water = new Picture("water.jpg");
    water.explore();
    water.fixUnderwater();
    water.explore();
  }

  public static void testMirrorVerticalRightToLeft() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorVerticalRightToLeft();
    beach.explore();
  }

  public static void testMirrorHorizontal() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorHorizontal();
    beach.explore();
  }

  public static void testMirrorHorizontalBotToTop() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorHorizontalBotToTop();
    beach.explore();
  }

  public static void testMirrorDiagonal() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorDiagonal();
    beach.explore();
  }

  public static void testMirrorArms() {
    Picture snowman = new Picture("snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();
  }

  public static void testMirrorGull() {
    Picture gull = new Picture("seagull.jpg");
    gull.explore();
    gull.mirrorGull();
    gull.explore();
  }

  public static void testCopyPart() {
    Picture canvas = new Picture("640x480.jpg");
    Picture beach = new Picture("beach.jpg");
    canvas.copyPart(beach, 0, 100, 0, 100, 0, 0);
    beach.explore();
    canvas.explore();
  }

  public static void testMyCollage() {
    Picture canvas = new Picture("640x480.jpg");
    canvas.myCollage();
    canvas.explore();
  }

  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    // testZeroBlue();
    // testKeepOnlyBlue();
    // testKeepOnlyRed();
    // testKeepOnlyGreen();
    // testNegate();
    // testFixUnderwater();
    // testGrayscale();
    // testMirrorVertical();
    // testMirrorVerticalRightToLeft();
    // testMirrorTemple();
    // testMirrorHorizontal();
    // testMirrorHorizontalBotToTop();
    // testMirrorArms();
    // testMirrorGull();
    // testMirrorDiagonal();
    // testCollage();
    // testCopy();
    // testCopyPart();
    testMyCollage();
    // testEdgeDetection();
    // testEdgeDetection2();
    // testChromakey();
    // testEncodeAndDecode();
    // testGetCountRedOverValue(250);
    // testSetRedToHalfValueInTopHalf();
    // testClearBlueOverValue(200);
    // testGetAverageForColumn(0);
  }
}