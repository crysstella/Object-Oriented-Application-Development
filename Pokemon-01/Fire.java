/**
 * Pokemon type Fire special attacks' functions that override by Charmander and Ponyta.
 *
 * @author Vo Nguyen
 */
public interface Fire{
  String specialMenu = "1. Ember\n2. Fire Blast\n3. Fire Punch";
  int numSpeicalMenuItems = 3;

  /**
   * Displays ember attack's damage.
   * @param p pokemon attacks.
   * @return a string that performs ember attack.
   */
  public String ember(Pokemon p);
  
  /**
   * Displays fire blast attack's damage.
   * @param p pokemon attacks.
   * @return a string that performs fire blast attack.
   */
  public String fireBlast(Pokemon p);

  /**
   * Displays fire punch attack's damage.
   * @param p pokemon attacks.
   * @return a string that performs fire punch attack.
   */
  public String firePunch(Pokemon p);
}