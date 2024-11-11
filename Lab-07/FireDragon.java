public class FireDragon extends Dragon{
  private final int LOW = 5;
  private final int HIGH = 9;
  private int fireShots;

  /**Constructor
   * Creating name, hp, and maxHp of the Fire Dragon.
   * Creating the number of fire shots to be 3 shots.
   * @param String n name of the Fire Dragon 
   * @param int mHp max HP given
  */
  public FireDragon(String n, int mHp){
    super(n, mHp);
    fireShots = 3;
  }

  /**If a fire dragon has any shots left, then generating a random amount 
   * of fireshot's damage.
   * If not, set the fireshot equals to 0.
   * @return a random number of fire shot damage in the range 5-9
  */
  public int fireShot(){
    if (fireShots > 0){
      fireShots--;
      return (int) (Math.random()*(HIGH-LOW+1)) + LOW;
    }
    return 0;
  }

  /**Display the name and hp (hp/maxhp), and the number of shots left.
  */
  @Override
  public String toString(){
    return (super.toString()) + "\n   Fire Shots remaining: " + fireShots; 
  }

}