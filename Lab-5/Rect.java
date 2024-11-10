/** Rect.java - represents the size (width & height) of a rectangle 
 * and its location (x, y)
*/
public class Rect {
  private int x;
  private int y;
  private int width;
  private int height;

  /** Constructs a rectangle 
   * @param w width of a rectangle
   * @param h height of a rectangle
  */
  public Rect(int w, int h){
    width = w;
    height = h;
  }
  
  /** Retrieves the value of the x coordidnate
   * @return x coordinate of the rectangle
  */
  public int getX(){
    return x;
  }

  /** Retrieves the value of the y coordinate
   * @return y coordinate of the rectangle
  */
  public int getY(){
    return y;
  }

  /** Retrieves the value of the width of a rectangle
   * @return width width of the rectangle
  */
  public int getWidth(){
    return width;
  }

  /** Retrieves the value of the height of a rectangle
   * @return height height of the rectangle
  */
  public int getHeight(){
    return height;
  }

  /** Shifts the location of the rectangle by adding dx & dy
   * @param dx amount to move the rectangle in x direction
   * @param dy amount to move the rectangle in y direction
  */
  public void translate(int dx, int dy){
    x += dx;
    y += dy;
  }
  
}