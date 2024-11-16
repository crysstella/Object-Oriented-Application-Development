import java.util.Scanner;

/** 
 * Static functions used to check console input for validity.
 *
 * Use:	Place CheckInput class in the same project folder as your code.
 *	Call CheckInput functions from your code using "CheckInput."
 *
 * Example:  int num = CheckInput.getInt();
 *
 * @author Shannon Cleary 2020
 */
public class CheckInput {
  /**
	 * Checks if the inputted value is an integer and 
	 * within the specified range (ex: 1-10)
	 * @param low lower bound of the range.
	 * @param high upper bound of the range.
	 * @return the valid input.
	 */
	public static int getIntRange( int low, int high ) {
		Scanner inp = new Scanner( System.in );
		int input = 0;
		boolean valid = false;
		while( !valid ) {
			if( inp.hasNextInt() ) {
				input = inp.nextInt();
				if( input <= high && input >= low ) {
					valid = true;
				} else {
					System.out.print("Invalid.	Guess again: ");
				}
			} else {
				inp.next(); //clear invalid string
				System.out.print("Invalid.    Guess again: ");
			}
		}
		return input;
	}

}