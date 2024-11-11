/**
 * Oddish pokemon type Grass has special attacks: vine whip, razor leaf, 
 * and solar beam.
 *
 * vine whip 1-3 dmg
 * razor leaf 2-4 dmg
 * solar beam 0-3 dmg
 *
 * @author Matthew Kriesel
*/
public class Oddish extends Pokemon implements Grass{

  /**
   * Constructor
   * Creating a new pokemon Oddish: name, hp, and max Hp
   */
  public Oddish(){
    super("Oddish");
  }

  /**
   * Retrieve the Grass special menu
   * @return the Grass special menu
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
    return 3;
  }

  /**
   * Implements specific special attack
   * @param p pokemon attacks
   * @param move a num belongs to each type of special attack
   * @return a string that performs the attack
   */
  @Override
  public String specialAttack(Pokemon p, int move) {
    String attack;
    switch (move) {
			case 1:
        attack = vineWhip(p);
        break;
      case 2:
        attack = razorLeaf(p);
        break;
      case 3:
        attack = solarBeam(p);
        break;
      default:
        attack = vineWhip(p);
        break;
    }
    return attack;
	}

  /**
   * Generate random damage for vine whip attacks
   * Displays vine whip attack's damage
   * @param p pokemon attacks
   * @return a string that performs vine whip attack
   */
  @Override
  public String vineWhip(Pokemon p){
    int damage = (int)(GenerateRandom.genIntBtw(1, 3)*battleTable[2][p.getType()]);
		p.takeDamage(damage);
		return p.getName() + " is WHIPED and takes " + damage + " damage.";
  }

  /**
   * Generate random damage for razor leaf attacks
   * Displays razor leaf attack's damage
   * @param p pokemon attacks
   * @return a string that performs razor leaf attack
   */
  @Override
  public String razorLeaf(Pokemon p){
    int damage = (int)(GenerateRandom.genIntBtw(2, 4)*battleTable[2][p.getType()]);
		p.takeDamage(damage);
		return p.getName() + " LEAFED and takes " + damage + " damage.";
  }

  /**
   * Generate random damage for solar beam attacks
   * Displays solar beam attack's damage
   * @param p pokemon attacks
   * @return a string that performs solar beam attack
   */
  @Override
  public String solarBeam(Pokemon p){
    int damage = (int)(GenerateRandom.genIntBtw(0, 3)*battleTable[2][p.getType()]);
		p.takeDamage(damage);
		return p.getName() + " BEAMED with the power of the sun and takes " + damage + " damage.";
  }

}