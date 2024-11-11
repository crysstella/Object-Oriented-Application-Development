/**
 * Generating a random number within a range.
 *
 * @author Keyi Wang
 */
import java.util.Random;

public class GenerateRandom {
	
  /**
   * Generate random int between left and right(inclusive).
   * @param left lowest value in the range.
   * @param right highest value in the range.
   * @return a random number between left and right.
   */
	public static int genIntBtw (int left, int right) {
		Random r = new Random();
		return Math.abs(r.nextInt()) % (right + 1 - left) + left;
	}
}