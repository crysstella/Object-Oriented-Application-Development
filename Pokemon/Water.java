/**
 * Pokemon type Water special attacks' functions that override by Squirtle and Staryu.
 * 
 * @author Keyi Wang
 */
 
public interface Water{
  String specialMenu = "1. Water Gun\n2. Bubble Beam\n3. Waterfall";
  int numSpeicalMenuItems = 3;

  /**
   * Displays water gun attack's damage.
   * @param p pokemon attacks.
   * @return a string that performs water gun attack.
   */
  public String waterGun(Pokemon p);

  /**
   * Displays bubble beam attack's damage.
   * @param p pokemon attacks.
   * @return a string that performs bubble beam attack.
   */
  public String bubbleBeam(Pokemon p);

  /**
   * Displays waterfall attack's damage.
   * @param p pokemon attacks.
   * @return a string that performs waterfall attack.
   */
  public String waterfall(Pokemon p);
  
}