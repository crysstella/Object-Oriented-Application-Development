public class Undead extends Monster{
   /**
   * Constructor Undead with 7 hp
   */
  public Undead(){
    super("Undead ", 7);
  }

  /**
   * Damage Undead attacks.
   * @return 3 damage.
   */
  @Override
  public int attack(){
    return 3;
  }
}