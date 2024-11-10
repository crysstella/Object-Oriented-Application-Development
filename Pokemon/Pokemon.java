/**
 * An abstract class that is extened by a specific pokemon;
 * it consists basic attacks and a battle table that will be used in the battle event.
 * @author Matthew Kriesel
 */
 public abstract class Pokemon extends Entity {
  public static final double [][] battleTable ={{1, .5, 2},
                                               {2, 1, .5},
                                               {.5, 2, 1}};
  
  /**
   * Constructor
   * Creating initial pokemon's name, hp, and max HP
   *
   * @param n pokemon name
   */
  public Pokemon(String n){
    super(n, GenerateRandom.genIntBtw(20, 25));
  }

  /**
   * Display the special attack menu
   * @return the special attack menu
   */
  public abstract String getSpecialMenu();

  /**
   * Retrieve the number of special menu items
   * @return the number of special menu items
   */
  public abstract int getNumSpecialMenuItems();

  /**
   * Implements specific special attack
   * @param p pokemon attacks
   * @param move a num belongs to each type of special attack
   * @return a string that performs the attack
   */
  public abstract String specialAttack(Pokemon p, int move);

  /**
   * Display 3 basic attack menu
   * @return a string basic attack menu
   */
  public String getBasicMenu(){
    return "1. Slam\n2. Tackle\n3. Punch";
  }

  /**
   * Retrieve the number of basic menu items
   * @return the number of basic menu items
   */
  public int getNumBasicMenuItems(){
    return 3;
  }

  /**
   * Implements specific basic attack
   * @param p pokemon attacks
   * @param move a num belongs to each type of basic attack
   * @return a string that performs the attack
   */
  public String basicAttack(Pokemon p, int move){
    String attack;
    switch (move) {
			case 1:
        attack = slam(p);
        break;
      case 2:
        attack = tackle(p);
        break;
      case 3:
        attack = punch(p);
        break;
      default:
        attack = slam(p);
        break;
    }
    return attack;
  }

  /**
   * Display attack menu option: basic and special attack
   * @return a string of attack menu
   */
  public String getAttackMenu(){
    return "1. Basic Attack\n2. Special Attack";
  } 

  /**
   * Retrieve a number of attack menu item
   * @return a number of attack menu item
   */
  public int getNumAttackMenuItems(){
    return 2;
  }

  /**
   * Generate random damage for slam attacks
   * Displays slam attack's damage
   * @param p pokemon attacks
   * @return a string that performs slam attack
   */
  public String slam(Pokemon p){
		int damage = GenerateRandom.genIntBtw(0, 5);
		p.takeDamage(damage);
		return p.getName() + " is SLAMMED and takes " + damage + " damage.";
  }

  /**
   * Generate random damage for tackle attacks
   * Displays tackle attack's damage
   * @param p pokemon attacks
   * @return a string that performs tackle attack
   */
  public String tackle(Pokemon p){
    int damage = GenerateRandom.genIntBtw(2, 3);
		p.takeDamage(damage);
		return p.getName() + " is TACKLED and takes " + damage + " damage.";
  }

  /**
   * Generate random damage for punch attacks
   * Displays punch attack's damage
   * @param p pokemon attacks
   * @return a string that performs punch attack
   */
  public String punch(Pokemon p){
    int damage = GenerateRandom.genIntBtw(1, 4);
		p.takeDamage(damage);
		return p.getName() + " is PUNCHED and takes " + damage + " damage.";
  }

  /**
   * Finding a type that a pokemon is:
   * Fire is 0, Water is 1, and Grass is 2
   * @return a number of a type of Pokemon
   */
  public int getType(){
    if (this instanceof Fire){
      return 0;
    } else if (this instanceof Water){
      return 1;
    } else{
      return 2;
    }
  }
}