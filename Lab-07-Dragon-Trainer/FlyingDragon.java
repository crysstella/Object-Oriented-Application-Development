public class FlyingDragon extends Dragon{
  private final int LOW = 5;
  private final int HIGH = 10;
  private int swoops;

  /**Constructor
   * Creating name, hp, and maxHp of the Flying Dragon.
   * Creating the number of swoops to be 5 swoops.
   * @param String n name of the Flying Dragon 
   * @param int mHp max HP given
  */
  public FlyingDragon(String n, int mHp){
    super(n, mHp);
    swoops = 5;
  }

  /**If a flying dragon has any swoops left, then generating a random amount 
   * of swoop's damage.
   * If not, set the swoop equals to 0.
   * @return a random number of swoops' damage in the range 5-10
  */
  public int swoopAttack(){
    if (swoops > 0){
      swoops--;
      return (int) (Math.random()*(HIGH-LOW+1)) + LOW;
    }
    return 0;
  }

  /**Display the name and hp (hp/maxhp), and the number of swoops left.
  */
  @Override
  public String toString(){
    return (super.toString()) + "\n   Swoop attacks remaining: " + swoops; 
  }
}