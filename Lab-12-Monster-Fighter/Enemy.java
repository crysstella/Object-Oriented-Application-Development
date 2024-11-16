public class Enemy{
  private String name;
  private int maxHp;
  private int hp;


  /**
   * A constructor initalizes name, maxHp, and hp.
   * 
   * @param n name of the enemy.
   * @param h initial hp and max hp.
   */
  public Enemy(String n, int h){
    name = n;
    maxHp = h;
    hp = h;
  }

  /**
   * A copy constructor 
   *
   * @param e the enemy object copied
   */
  public Enemy(Enemy e){
    if (e != null){
      this.name = e.name;
      this.maxHp = e.maxHp;
      this.hp = e.hp;
    }
  }

  /**
   * Retrieve the enemy's name.
   *
   * @return the enemy's name.
   */
  public String getName(){
    return name;
  }

  /**
   * Retrieve the enemy's current hp.
   *
   * @return the enemy's current hp.
   */
  public int getHp(){
    return hp;
  }

  /**
   * Enemy takes the amount of damage
   * and set it back to 0 if an enemy died.
   *
   * @param h the taken damage.
   */
  public void takeDamage(int h){
    hp = ((hp > h) ? (hp - h) : 0);
  }

  /**
   * An enemy attacks a player the amound of damage. 
   *
   * @return the damage attacked.
   */
  public int attack(){
    int damage = (int) ((Math.random()*4) + 1);
    return damage;

  }

  /**
   * Representation of an enemy's stats (name and hp/maxHp). 
   *
   * @return an enemy's stats. 
   */
  @Override
  public String toString(){
    return name + "\nHP: " + hp +"/" + maxHp;
  }

  /**
   * Copy an enemy object. 
   *
   * @return a copy of enemy object.
   */
  public Enemy clone(){
    return new Enemy( this );
  }
}