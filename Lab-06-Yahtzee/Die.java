public class Die {
  private int sides;
  private int value;

  /** Constructor - rolls to give the die an initial value
   *  @param s sets the number of sides of this die
   */
  public Die(int s){
    if (s > 1) {
      sides = s;
    }else{
      sides = 6;
    }
    value = 0;
  }

  /** Retrieve the die's value
   *  @return the die's value
   */
  public int getValue(){
    return value;
  }
  
  /** Rolls the die
   *  @return the die's value
   */
  public int roll(){
    value = (int)(Math.random()*sides) + 1;
    return value;
  }

/** Compares two Die objects to see if they are equal
 *  @param o object to compare to this Die object
 *  @return true if the two Die are equal
 */
 @Override
  public boolean equals(Object o){
    if (o instanceof Die){
      Die d = (Die) o;
      return sides == d.sides && value == d.value;
    }
    return false;
  }

  
  /** Compares two Die objects to see if one is less than another
  *  @param d Die object to compare to this Die object
  *  @return true if this Die object is less than d Die object 
  */
  public boolean lessThan(Die d){
    return (value < d.getValue());
  }

  /** Find the difference between two dice values
  *  @param d Die object to compare to this Die object
  *  @return the difference between this Die object and d Die object
  */
  public int difference(Die d){
    return (value - d.value);
  }
  
  /** String representation of a Die object
   *  @return string representation of this Die
   */
  @Override
  public String toString(){
    return "" + value;
  }
  
}