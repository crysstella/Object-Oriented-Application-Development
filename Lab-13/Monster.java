public abstract class Monster{
  private int hp;
  private String name;

    /**
     * Creating monster name and hp.
     * @param n monster's name.
     * @param h monster's hp.
     */
  public Monster(String n, int h){
    name = n;
    hp = h;
  }

  /**
   * Retrieve monster's name.
   * @return monster's name string.
   */
  public String getName(){
    return name;
  }

  /**
   * Retrieve monster's hp.
   * @return monster's hp.
   */
  public int getHp(){
    return hp;
  }

  /**
   * Declaration of attack method.
   */
  public abstract int attack();
}