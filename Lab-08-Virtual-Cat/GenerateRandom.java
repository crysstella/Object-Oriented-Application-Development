public class GenerateRandom{

  /**Generating number in specific range
   * @param low   the lowest value in range
   * @param high  the highest value in range
   * @return      random number in range 
  */
  public static int genIntRange(int low, int high){
    return (int) (Math.random()*(high-low+1)) + low;
  }
}