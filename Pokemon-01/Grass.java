/**
 * Pokemon type Grass special attacks' functions that override by Bulbasaur and Oddish. 
 *
 * @author Matthew Kriesel
 */
public interface Grass{
  String specialMenu = "1. Vine Whip\n2. Razor Leaf\n3. Solar Beam";
  int numSpeicalMenuItems = 3;

  /**
   * Displays vine whip attack's damage.
   * @param p pokemon attacks.
   * @return a string that performs vine whip attack.
   */
  public String vineWhip(Pokemon p);

  /**
   * Displays razor leaf attack's damage.
   * @param p pokemon attacks.
   * @return a string that performs razor leaf attack.
   */
  public String razorLeaf(Pokemon p);

  /**
   * Displays solar beam attack's damage.
   * @param p pokemon attacks.
   * @return a string that performs solar beam attack.
   */
  public String solarBeam(Pokemon p);
  
}