public class Poison extends MonsterDecorator{
  /**
   * Constructor Poison monster
   * with add extra name, and hp + 1 hp of Poison.
   * @param m monster 
   */
  public Poison(Monster m){
    super(m, "Poison Fanged " + m.getName(), m.getHp() + 1);
  }

   /**
   * total of Poison attack (4) and previous attack.
   * @returns total attack.
   */
  @Override
  public int attack(){
    return 4 + super.attack();
  }
}