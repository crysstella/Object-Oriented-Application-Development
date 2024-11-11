public class Player{
  private int hp;
  
  /**Constructor
   * Creating user's hp to 10
  */
  public Player(){
    hp = 10;
  }

  /**Retrieve hp value
   * @return hp value
  */
  public int getHp(){
    return hp;
  }

  /**Decreases the player's hp by amount d
   * @param d the amount hp decreases
  */
  public void takeDamage(int d){
    hp = (hp > d) ? (hp - d) : 0;
  }

  /**Displays user's hp / max hp
  */
  @Override
  public String toString(){
    return "You have " + hp + "/" + 10 + " HP\n";
  }
}