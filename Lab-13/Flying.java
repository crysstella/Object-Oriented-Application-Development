public class Flying extends MonsterDecorator{
  /**
   * Constructor Flying monster
   * with add extra name, and hp + 2 hp of Flying.
   * @param m monster 
   */
  public Flying(Monster m){
    super(m, "Flying " + m.getName(), 2 + m.getHp());
  }

   /**
   * total of Flying attack (3) and previous attack.
   * @returns total attack.
   */
  @Override
  public int attack(){
    return 3  + super.attack();
  }
}