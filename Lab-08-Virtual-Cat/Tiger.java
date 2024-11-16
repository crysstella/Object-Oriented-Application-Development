public class Tiger extends Cat{

  /**Constructor
   * Creating name and hunger level
   * @param String n name of the Tiger
  */
  public Tiger(String n){
    super(n);
  }

  /**Method to allow a user feeds a cat
   * @param p user feeds a cat 
   * @return the string representing the interaction  
  */
  @Override
  public String feed(Player p){
    if (getHunger() < 10){
      incrementHunger(10);
      return getName() + " is pretty hungry, and starts chomping down the food right away.";  
    }
    int d = GenerateRandom.genIntRange(1, 3);
    p.takeDamage(d);
    return getName() + " is already full, and bites and scratches you for insulting them with food. You take " + d + " damage.";
  }

  /**Method to allow a user plays with a cat 
   * @param p user plays with a cat 
   * @return the string representing the interaction  
  */
  @Override
  public String play(Player p){
    if (getHunger() == 1){
      int d = GenerateRandom.genIntRange(1, 3);
      p.takeDamage(d);
      incrementHunger(-1);
      return getName() + " is very hungry, and scratches you for forcing them playing. "; 
    }else if ((getHunger() > 1) && (getHunger() < 6)){
      incrementHunger(-1);
      if (getHunger() == 1){
        int d = GenerateRandom.genIntRange(1, 3);
        p.takeDamage(d);
        return getName() + " attempts to catch your fingers through the box.\n" + getName() + " accidentally scratches you for " + d + " damage.";
      }else{
        return getName() + " attempts to catch your fingers through the box.";
      }
    }else if ((getHunger() > 5) && (getHunger() < 10)){
      incrementHunger(-1);
      if (getHunger() == 1){
        int d = GenerateRandom.genIntRange(1, 3);
        p.takeDamage(d);
        return getName() + " jumps and plays with the string you dangle in front of them.\n" + getName() + " accidentally scratches you for " + d + " damage."; 
      }else{
        return  getName() + " jumps and plays with the string you dangle in front of them."; 
      }
    }

    incrementHunger(-1);
    if (getHunger() == 1){
        int d = GenerateRandom.genIntRange(1, 3);
        p.takeDamage(d);
        return getName() + " is so full, they can barely roll over to glare at you when you roll a jingle ball toward them.\n" + getName() + " accidentally scratches you for " + d + " damage.";
    }
    return getName() + " is so full, they can barely roll over to glare at you when you roll a jingle ball toward them.";
  }

  /**Method to allow a user pets a cat
   * @param p user pets a cat 
   * @return the string representing the interaction  
  */
  @Override
  public String pet(Player p){
    if (getHunger() == 1){
      int d = GenerateRandom.genIntRange(1, 3);
      p.takeDamage(d);
      return getName() + " is hungry, and scratches you for touching them."; 
    }else if ((getHunger() > 1) && (getHunger() < 10)){
      return getName() + " happily allows you to pet them.";
    }

    return getName() + " is so full, and purrs and falls asleep.";
  }
}