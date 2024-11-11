public class Beast extends Monster{
   /**
   * Constructor Beast with 5 hp
   */
  public Beast(){
    super("Beast ", 5);
  }

  /**
   * Damage Beast attacks.
   * @return 2 damage.
   */
  @Override
  public int attack(){
    return 2;
  }
}