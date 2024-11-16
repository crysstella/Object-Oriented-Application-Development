import java.util.Scanner;

public class CheckInput {
  /**
   * Takes in a string only letters from the user.
   * 
   * @return the inputted String.
   */
  public static String getString() {
    Scanner in = new Scanner(System.in);
    String input = "";
    boolean valid = false;

    while (!valid) {
      valid = true;
      input = in.nextLine().trim();
      for (int i = 0; i < input.length(); i++) {
        if (!Character.isAlphabetic(input.charAt(i))) {
          System.out.println("Input does not contain numbers, spaces, or special characters!");
          System.out.print("Enter word: ");
          valid = false;
          break;
        }
      }
    }
    return input;
  }

  /**
   * Checks if the inputted value is an integer and within the specified range
   * (ex: 1-10)
   * 
   * @param low  lower bound of the range.
   * @param high upper bound of the range.
   * @return the valid input.
   *
   * @author Shannon Cleary 2020
   */
  public static int getIntRange(int low, int high) {
    Scanner in = new Scanner(System.in);
    int input = 0;
    boolean valid = false;
    while (!valid) {
      if (in.hasNextInt()) {
        input = in.nextInt();
        if (input <= high && input >= low) {
          valid = true;
        } else {
          System.out.println("Invalid Range.");
        }
      } else {
        in.next(); // clear invalid string
        System.out.println("Invalid Input.");
      }
    }
    return input;
  }
}