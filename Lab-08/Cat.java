public abstract class Cat{
  private String name;
  private int hunger;

  /**Constructor
   * Creating name and hunger level
   * @param String n name of the cat
  */
  public Cat(String n){
    name = n;
    incrementHunger(1);
  }

  /**Retrieve the Cat's name.
   * @return the Cat's name
  */
  public String getName(){
    return name;
  }
  
  /**Retrieve hunger's value
   * @return hunger's value
  */
  public int getHunger(){
    return hunger;
  }

  /**Modify the cat's hunger level (1-10)
   * @param val the amount to modify hunger level
   * @return hunger level after modify
  */
  public int incrementHunger(int val){
    return hunger = (hunger+val > 10) ? 10 : (hunger+val < 1) ? 1 : hunger + val;
  }

  /**Display the cat's states: hungry, full, or satisfied.
  */
  @Override
  public String toString(){
    if (hunger == 1){
      return name + " is hungry";
    }else if (hunger == 10){
      return name + " is full";
    }
    return name + " is satisfied";
  }

  /**Method to allow a user feeds a cat
   * @param p user feeds a cat 
   * @return the string representing the interaction  
   */
  public abstract String feed(Player p);

  /**Method to allow a user plays with a cat 
   * @param p user plays with a cat 
   * @return the string representing the interaction  
   */
  public abstract String play(Player p);

  /**Method to allow a user pets a cat
   * @param p user pets a cat 
   * @return the string representing the interaction  
   */
  public abstract String pet(Player p);
}