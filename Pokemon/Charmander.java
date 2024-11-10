/**
 * Charmander pokemon type Fire has special attacks: ember, fire blast, 
 * and fire punch.
 * 
 * ember 0-3 dmg
 * fire blast 1-4 dmg
 * fire punch 1-3 dmg
 * 
 * @author Vo Nguyen
 */

public class Charmander extends Pokemon implements Fire {

  /**
   * Constructor
   * Creating a new pokemon Charmander: name, hp, and max Hp.
   */
	public Charmander() {
		super("Charmander");
	}

  /**
   * Retrieve the Fire special menu.
   * @return the Fire special menu.
   */
  @Override
	public String getSpecialMenu() {
    return specialMenu;
	}

  /**
   * Retrieve the number of special menu items.
   * @return the number of special menu items.
   */
  @Override
	public int getNumSpecialMenuItems() {
    return numSpeicalMenuItems;
	}

  /**
   * Implements specific special attack.
   * @param p pokemon attacks.
   * @param move a num belongs to each type of special attack.
   * @return a string that performs the attack.
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
   * Generate random damage for ember attacks and
   * displays ember attack's damage.
   * @param p pokemon attacks.
   * @return a string that performs ember attack.
   */
	@Override
	public String ember(Pokemon p) {
    int damage = GenerateRandom.genIntBtw(0, 3);
    damage = (int)(damage*battleTable[0][p.getType()]);
    p.takeDamage(damage);
		return p.getName() + " is encased in EMBERS and takes " + damage + " damage.";
	}

  /**
   * Generate random damage for fire blast attacks and
   * displays fire blast attack's damage.
   * @param p pokemon attacks.
   * @return a string that performs fire blast attack.
   */
	@Override
	public String fireBlast(Pokemon p) {
    int damage = GenerateRandom.genIntBtw(1, 4);
    damage = (int)(damage*battleTable[0][p.getType()]);
    p.takeDamage(damage);
		return p.getName() + " is BLASTED with FIRE and takes " + damage + " damage.";
	}

  /**
   * Generate random damage for fire punch attacks
   * and displays fire punch attack's damage.
   * @param p pokemon attacks.
   * @return a string that performs fire punch attack.
   */	
	@Override
	public String firePunch(Pokemon p) {
    int damage = GenerateRandom.genIntBtw(1, 3);
    damage = (int)(damage*battleTable[0][p.getType()]);
    p.takeDamage(damage);
		return p.getName() + " is PUNCHED by FIRE and takes " + damage + " damage.";
	}	

}