import org.code.theater.*;
import org.code.media.*;
public class TheaterRunner {
  public static void main(String[] args) {

    
   String[][] titles = { 
                         {"Naturals"},
                         {"InheritanceGames"},
                         {"Mistborn"},
                         {"DivineRivals"},
                         {"Powerless"},
                       };


   double[][] ratings = { 
                         {5.0},
                         {4.5},
                         {4.0},
                         {5.0},
                         {4.5},
                       };
 
String[][] reviews = { 
                         {"My favorite mystery series ever!"},
                         {"Loveable characters with insance plot twists!"},
                         {"Amazing world building and characters!"},
                         {"My favorite romance fantasy series."},
                         {"Love the drama between the main characters."},
                       };

    
    MyStory scene = new MyStory(titles, ratings, reviews);

    scene.drawScene();

    Theater.playScenes(scene);

  }
}