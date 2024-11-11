/**
 * Contains a infomation of position of an entity.
 */
public class Point{
  private int x;
  private int y;

  /** 
   * Constructs a point at (x,y)
   * @param xVal the x coordinate of the new point
   * @param yVal the y coordinate of the new point
   */
  public Point(int xVal, int yVal){
    x = xVal;
    y = yVal;
  }

  /** 
   * Shifts the location of the point by adding dx and dy
   * @param dx amount to move this point in x direction 
   * @param dy amount to move this point in y direction
   */
  public void translate(int dx, int dy){
    x += dx;
    y += dy;
  }

  /** 
   * Retrieves the value of the x coordinate
   * @return x coordinate of the point
   */
  public int getX(){
    return x;
  }

  /**
   * Retrieves the value of the y coordinate
   * @return y coordinate of the point 
   */
  public int getY(){
    return y;
  }

  /**
   * Changes the location of the point 
   * @param xVal new x coordinate for this point
   */
  public void setX(int xVal) {
		x = xVal;
	}
	
  /** 
   * Changes the location of the point 
   * @param yVal new y coordinate for this point
   */
	public void setY(int yVal) {
		y = yVal;
	}

  /**
   * Changes the location of the point 
   * @param xVal new x coordinate for this point
   * @param yVal new y coordinate for this point 
   */
  public void setLocation(int xVal, int yVal){
    x = xVal;
    y = yVal;
  }

  /** 
   * String representation of a Point object 
   * @return string representation of this point 
   */
  @Override
  public String toString(){
    return "(" + x + ", " + y + ")";
  }
}