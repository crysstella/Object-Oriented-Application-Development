public class Dragon{
  private final int LOW = 3;
  private final int HIGH = 7;
  private String name;
  private int hp;
  private int maxHp;

  /**Constructor
   * Creating name, hp, and maxHp of the Dragon.
   * @param String n name of the Dragon 
   * @param int mHp max HP given
  */
  public Dragon(String n, int mHp){
    name = n;
    hp = mHp;
    maxHp = mHp;
  }

  /**Retrieve the Dragon's name.
   * @return the Dragon's name
  */  
  public String getName(){
    return name;
  }
  /**Retrieve the Dragon's current HP.
   * @return the Dragon's current HP
  */
  public int getHp(){
    return hp;
  }

  /**Generate a random amount of damage in the range 3-7.
   * @return a random amount of damage in the range 3-7
  */
  public int attack(){
    return (int) (Math.random()*(HIGH-LOW+1)) + LOW;
  }

  /**Subtract the current HP of the dragon by damage takentaken.
   * If HP is less than 0, HP equals 0.
   * @param d damage taken by the Dragon
  */
  public void takeDamage(int d){
    hp -= d;
    if (hp < 0) {
      hp = 0;
    }
  }

  /** Display the dragon's name and hp/maxHp.
  */
  @Override
  public String toString(){
    return "Attack " + name + ": " + hp + "/" + maxHp;
  }
}