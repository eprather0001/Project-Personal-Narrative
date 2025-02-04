import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus{

public ImageFilter(String filename){
  super(filename);
}

 public void colorize() {
    Pixel[][] pixels = getImagePixels();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];
        int grayValue = currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue();
        grayValue /= 3;

        if (grayValue < 85) {
          currentPixel.setRed(255);
          currentPixel.setGreen(0);
          currentPixel.setBlue(0);
        }
        else if (grayValue < 170) {
          currentPixel.setRed(0);
          currentPixel.setGreen(255);
          currentPixel.setBlue(0);
        }
        else {
          currentPixel.setRed(0);
          currentPixel.setGreen(0);
          currentPixel.setBlue(255);
        }
      }
    }

    
  }


  public void adjustContrast(int multiplier) {
    Pixel[][] pixels = getPixelsFromImage();
    for(int row = 0; row < pixels.length; row++){
      for(int col = 0; col < pixels[row].length; col++){
        Pixel currentPixel = pixels[row][col];

        int newRed = currentPixel.getRed() * multiplier;
        int newGreen = currentPixel.getGreen() * multiplier;
        int newBlue = currentPixel.getBlue() * multiplier;
       
        if (newRed >  255){
          // set to 255
          newRed = 255;
        }
       
        if (newBlue > 255){
          newBlue = 255;
        }
       
        if (newGreen > 255){
          newGreen = 255;
        }

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
   
  }
 
  }
}

   public void saturate(int factor) {
       Pixel[][] pixels = getPixelsFromImage();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];
            int red = currentPixel.getRed();
            int green = currentPixel.getGreen();
            int blue = currentPixel.getBlue();
           int average = (red + green + blue) / 3;

           
            int adjustedGrayscale = average + (average - 255) * factor;

            int newRed = (int)(2 * adjustedGrayscale - red);
            int newGreen = (int)(2 * adjustedGrayscale - green);
            int newBlue = (int)(2 * adjustedGrayscale - blue);

   
            newRed = Math.min(newRed, 255);
            newGreen = Math.min(newGreen, 255);
            newBlue = Math.min(newBlue, 255);

           
            currentPixel.setRed(newRed);
            currentPixel.setGreen(newGreen);
            currentPixel.setBlue(newBlue);
      }
    }
  }



    public void motionBlur(int length, String direction) {
      Pixel[][] pixels = getPixelsFromImage();
          for (int row = 0; row < pixels.length; row++) {
        for (int col = 0; col < pixels[0].length; col++) {
            Pixel currentPixel = pixels[row][col];
            int totalRed = 0, totalGreen = 0, totalBlue = 0;
            int count = 0;

            // Traverse neighboring pixels based on the specified direction
            for (int i = 0; i < length; i++) {
                int newRow = row;
                int newCol = col;

                // Determine new pixel position based on direction
                if (direction.equals("horizontal")) {
                    newCol += i;
                } else if (direction.equals("vertical")) {
                    newRow += i;
                } else if (direction.equals("diagonal")) {
                    newRow += i;
                    newCol += i;
                }

                // Check if the new position is within bounds
                if (newRow < pixels.length && newCol < pixels[0].length) {
                    Pixel neighborPixel = pixels[newRow][newCol];
                    totalRed += neighborPixel.getRed();
                    totalGreen += neighborPixel.getGreen();
                    totalBlue += neighborPixel.getBlue();
                    count++;
                }
            }

            // Calculate average color values
            if (count > 0) {
                currentPixel.setRed(totalRed / count);
                currentPixel.setGreen(totalGreen / count);
                currentPixel.setBlue(totalBlue / count);
            }
        }
    }
   }


  

  
}