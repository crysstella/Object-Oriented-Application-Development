/**
 * Staryu pokemon type Water has special attacks: water gun, bubble beam,
 * and water fall.
 *
 * water gun 1-5 dmg
 * bubble beam 1-2 dmg
 * waterfall 1-4 dmg
 *
 * @author Keyi Wang
*/

public class Staryu extends Pokemon implements Water {

	/**
   * Constructor
   * Creating a new pokemon Staryu: name, hp, and max Hp
   */
	public Staryu() {
		super("Staryu");
	}

  /**
   * Retrieve the Water special menu
   * @return the Water special menu
   */
  @Override
	public String getSpecialMenu() {
		return specialMenu;
	}

  /**
   * Retrieve the number of special menu items
   * @return the number of special menu items
   */
  @Override
	public int getNumSpecialMenuItems() {
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
		String attackMsg = "";
		switch (move) {
		case 1:
			attackMsg = waterGun(p);
			break;
		case 2:
			attackMsg = bubbleBeam(p);
			break;
		case 3:
			attackMsg = waterfall(p);
			break;
		}
		return attackMsg;
    	
	}

  /**
   * Generate random damage for water gun attacks
   * Displays water gun attack's damage
   * @param p pokemon attacks
   * @return a string that performs water gun attack
   */
  @Override
	public String waterGun(Pokemon p) {
		int damage = (int) (GenerateRandom.genIntBtw(1, 5) * Pokemon.battleTable[1][p.getType()]);
		p.takeDamage(damage);
		return p.getName() + " is SPRAYED by WATER GUN" + " and takes " + damage + " damage.";
	}

  /**
   * Generate random damage for bubble beam attacks
   * Displays bubble beam attack's damage
   * @param p pokemon attacks
   * @return a string that performs bubble beam attack
   */
  @Override
	public String bubbleBeam(Pokemon p) {
		int damage = (int) (GenerateRandom.genIntBtw(1, 2) * Pokemon.battleTable[1][p.getType()]);
		p.takeDamage(damage);
		return p.getName() + " is WARPPED by BUBBLE BEAM" + " and takes " + damage + " damage.";
	}

  /**
   * Generate random damage for waterfall attacks
   * Displays waterfall attack's damage
   * @param p pokemon attacks
   * @return a string that performs waterfall attack
   */
  @Override
	public String waterfall(Pokemon p) {
		int damage = (int) (GenerateRandom.genIntBtw(1, 4) * Pokemon.battleTable[1][p.getType()]);
		p.takeDamage(damage);
		return p.getName() + " is SMASHED by WATER FALL" + " and takes " + damage + " damage.";
	}

}