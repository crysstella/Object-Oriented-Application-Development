import java.util.*;

public class Ball {
  private static HashMap<String, Ball> colors = new HashMap<String, Ball>();
  private String color;
  private int bounces;
  private int rolls;

  /**
   * Private Ball object constructor: initalize its colors, the amount of bounces and rolls.
   * @param c specific color of the ball object.
   */
  private Ball(String c) {
    color = c;
    bounces = 0;
    rolls = 0;

  }

  /**
   * Retrieve the ball object and add it to colors hash map.
   * @param c specific color of the ball object.
   * @return the ball object with color c.
   */
  public static Ball getInstance( String c ){
    Ball ball;
    if (colors.size() == 0){
      ball = new Ball(c);
      colors.put(c, ball);
    }else{
      if (colors.containsKey(c)){
        ball = colors.get(c);
      }else{
        ball = new Ball(c);
        colors.put(c, ball);
      }
    }
    
    return ball;
  }

  /**
   * Increase the amount of bounces by 1.
   */
  public void bounce(){
    bounces++;
  }

  /**
   * Increase the amount of roll by 1.
   */
  public void roll(){
    rolls++;
  }

  /**
   * Display Ball object properties: color, the amount of bounces and rolls.
   * @return representation of the ball object.
   */
  @Override
  public String toString(){
    return color + " Ball:\n" 
                 + "--------\n"   
                 + "Rolls: " + rolls
                 + "\nBounces: " + bounces;
  }

}