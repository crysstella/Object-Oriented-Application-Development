public class Alien extends Monster{
  /**
   * Constructor Alien with 6 hp
   */
  public Alien(){
    super( "Alien ", 6);
  }

  /**
   * Damage Alien attacks.
   * @return 1 damage.
   */
  @Override
  public int attack(){
    return 1;
  }
  
}