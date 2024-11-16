public class Lasers extends MonsterDecorator{
  /**
   * Constructor  Lasers monster
   * with add extra name, and hp + 1 hp of Lasers
   * @param m monster 
   */
  public Lasers(Monster m){
    super(m, m.getName() + "with Laser Beams ", 1 + m.getHp());
  }

   /**
   * total of Lasers attack (4) and previous attack.
   * @returns total attack.
   */
  @Override
  public int attack(){
    return 4  + super.attack();
  }
}