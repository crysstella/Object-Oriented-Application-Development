import java.util.*;

public class CheckInput{
  /**
   * Read a user's input and check if it is within range.
   *
   * @param low the lowest value within range.
   * @param high the highest value within range.
   * @return the user's input within range.
  */
  public static int inRange(int low, int high){
    Scanner read = new Scanner(System.in);
    int inp = 0;
    boolean valid = false;

    while (!valid){
      if (read.hasNextInt()){
        inp = read.nextInt();
        if ((inp >= low) && (inp <= high)){
          valid = true;
        }else{
          System.out.println("Invalid Range!");
        }
      }else{
        read.next();
        System.out.println("Invalid Input!");
      }
    }
    return inp;
  }
}