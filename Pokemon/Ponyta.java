/**
 * Ponyta pokemon type Fire has special attacks: ember, fire blast, 
 * and fire punch.
 * 
 * ember 0-4 dmg
 * fire blast 2-5 dmg
 * fire punch 1-4 dmg
 * 
 * @author Vo Nguyen
*/

public class Ponyta extends Pokemon implements Fire{

  /**
   * Constructor
   * Creating a new pokemon Ponyta: name, hp, and max Hp
   */
  public Ponyta(){
    super("Ponyta");
  }

  /**
   * Retrieve the Fire special menu
   * @return the Fire special menu
   */
  @Override
  public String getSpecialMenu(){
    return specialMenu;
  }

  /**
   * Retrieve the number of special menu items
   * @return the number of special menu items
   */
  @Override
  public int getNumSpecialMenuItems(){
    return numSpeicalMenuItems;
  }

  /**
   * Implements specific special attack
   * @param p pokemon attacks
   * @param move a num belongs to each type of special attack
   * @return a string that performs the attack
   */
  @Override
	public String specialAttack(Pokemon p, int move) {
    String attack = "";
    switch (move){
      case 1:
        attack = ember(p);
        break;
      case 2:
        attack = fireBlast(p);
        break;
      case 3:
        attack = firePunch(p);
        break;
    }

    return attack;
	}
  
  /**
   * Generate random damage for ember attacks
   * Displays ember attack's damage
   * @param p pokemon attacks
   * @return a string that performs ember attack
   */
	@Override
	public String ember(Pokemon p) {
    int damage = GenerateRandom.genIntBtw(0, 4);
    damage = (int)(damage*battleTable[0][p.getType()]);
    p.takeDamage(damage);
		return p.getName() + " is encased in EMBERS and takes " + damage + " damage.";
	}

  /**
   * Generate random damage for fire blast attacks
   * Displays fire blast attack's damage
   * @param p pokemon attacks
   * @return a string that performs fire blast attack
   */
	@Override
	public String fireBlast(Pokemon p) {
    int damage = GenerateRandom.genIntBtw(2, 5);
    damage = (int)(damage*battleTable[0][p.getType()]);
    p.takeDamage(damage);
		return p.getName() + " is BLASTED with FIRE and takes " + damage + " damage.";
	}

  /**
   * Generate random damage for fire punch attacks
   * Displays fire punch attack's damage
   * @param p pokemon attacks
   * @return a string that performs fire punch attack
   */
	@Override
	public String firePunch(Pokemon p) {
    int damage = GenerateRandom.genIntBtw(1, 4);
    damage = (int)(damage*battleTable[0][p.getType()]);
    p.takeDamage(damage);
		return p.getName() + " is PUNCHED by FIRE and takes " + damage + " damage.";
	}

}