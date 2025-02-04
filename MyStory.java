import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene{

private String[][] title;
private double[][] rating;
private String[][] review;


public MyStory(String[][] title, double[][] rating, String[][] review){
  this.title = title;
  this.rating = rating;
  this.review = review;
}


public void drawScene(){
drawIntroScene();
  drawTemplateScene();
  drawEndingScene();
}


  
  public void drawTemplateScene(){
    for (int row = 0; row < title.length; row++) {
      for (int col = 0; col < title[0].length; col++) {
        //1. clear the scene / draw background
        clear("pink");
        //2. set any style (text size, font, font style, etc)
        setTextHeight(30);
        setTextColor("white");
        //3. Draw the text and images, play sounds
        drawText("Rating: " + rating[row][col], 220, 195);
        setTextHeight(17);
        drawText("Review: " + review[row][col], 10, 335);    
       setTextHeight(30);
        drawText(title[row][col], 20, 50);
        ImageFilter bookImage = new ImageFilter(title[row][col] + ".JPG");
        drawImage(bookImage, 20, 75, 170);
        pause(1);
        if(row == 0){
          bookImage.colorize();
        }
        else if(row==1){
          bookImage.adjustContrast(2);
        }
        else if(row==2){
          bookImage.saturate(2);
        }
        else if(row==3){
          bookImage.motionBlur(50,"diagonal");
        }
        else if(row==4){
          bookImage.colorize();
        }
        drawImage(bookImage, 20, 75, 170);
        pause(1.5);
        
        //4. Pause before transitioning
      }
    }    
  }

public void drawIntroScene(){
  clear("pink");
  setTextHeight(30);
  setTextColor("white");
  drawText("Ellie's Favorite", 100, 175);
 drawText("Books Review!", 100, 225);
playSound("crowdclapping.wav");
pause(3);
}

public void drawEndingScene(){
   clear("pink");
  setTextHeight(30);
  setTextColor("white");
  drawText("Thank you!", 115, 200);
pause(3);
}


  
}