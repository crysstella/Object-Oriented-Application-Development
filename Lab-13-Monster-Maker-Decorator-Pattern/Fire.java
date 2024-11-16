public class Fire extends MonsterDecorator{
  /**
   * Constructor Fire monster
   * with add extra name, and hp + 2 hp of Fire.
   * @param m monster 
   */
  public Fire(Monster m){
    super(m, "Firey " + m.getName(), 2 + m.getHp());
  }

  /**
   * total of Fire attack (5) and previous attack.
   * @returns total attack.
   */
  @Override
  public int attack(){
    return 5 + super.attack();
  }
}