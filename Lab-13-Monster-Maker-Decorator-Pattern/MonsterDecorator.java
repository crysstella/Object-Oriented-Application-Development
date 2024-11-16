public abstract class MonsterDecorator extends Monster{
  Monster monster;

  /**
   * constructor sets name and hp when Monster Created.
   * @param m Monster.
   * @param addName extra name.
   * @param addHp hp added.
   */ 
  public MonsterDecorator(Monster m, String addName, int addHp){
    super(addName, addHp);
    monster = m;
  }

  /**
   * Retrieve monster's attack.
   * @return monster's attack value.
   */
  @Override
  public int attack(){
    return monster.attack();
  }
}