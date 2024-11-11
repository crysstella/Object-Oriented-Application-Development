public class Player {
  private final int NUM_DICE = 3;
  private Die[] dice;
  private int points;

/**Constructor construct an array of 3 dice, and construct each Die object with 6 sides
 * Initialize points as 0
 */
  public Player(){
    dice = new Die[NUM_DICE];
    for (int i=0; i < dice.length; i++){
      dice[i] = new Die(6);
    }
    points = 0;
  }

  /** Retrieve the score's value
   *  @return the player points
   */
  public int getPoints(){
    return points;
  }

  /**Sort the three dice in ascending order
   */

  public void sort(){
    for (int i=0; i < NUM_DICE-1 ; i++){
      for(int j=i+1; j < NUM_DICE; j++){
        if (dice[j].lessThan(dice[i])){
          Die temp = dice[j];
          dice[j] = dice[i];
          dice[i] = temp;
        }
      }
    }
  }

  /**Check if two dices values are the same
   * Add 1 point to points if it's true
   * @return true if two dices are the same 
   * @return false if two dices are not the same
   */
  public boolean pair(){
    int count = 0;
    for (int i=0; i < NUM_DICE-1; i++){
      if (dice[i].equals(dice[i+1])){
        count++;
      }
    }
    if (count != 0){
      points++;
      return true;
    }
    return false;
  }

  /**Check if three dices values are the same
   * Add 3 points to points if it's true
   * @return true if all three dices are the same 
   * @return false if all three dices are not the same
   */
  public boolean threeOfAKind(){
    int i = 0;
    if ((dice[i].equals(dice[i+1])) && (dice[i].equals(dice[i+2]))){
      points+=3;
      return true;
    }

    return false;
  }
  
  /**Check if three dices values in a series
   * Add 2 points to points if it's true
   * @return true if all three dices in a series 
   * @return false if all three dices in a series
   */
  public boolean series(){
    sort();
    int i=0;
    if (((dice[i+1].difference(dice[i])) == 1)
       && (dice[i+2].difference(dice[i+1])) == 1){
      points+=2;
      return true;
    }
    return false;
  }

  /**Roll the three dice and sort them in ascending order
   */
  public void roll(){
    for (int i=0; i < NUM_DICE; i++){
      dice[i].roll();
    }
    sort();
  }

  /**String representation of Player object
   * @return string representation of this Player
  */
  @Override
  public String toString(){
    return "D1=" + dice[0] + ", D2=" + dice[1] + ", D3=" + dice[2];
  }
}