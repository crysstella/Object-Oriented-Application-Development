import java.util.Scanner;

public class CheckInput{
  final static int LOW = 5;
  final static int HIGH = 10;

  /**Check an integer if it is valid
   * If not, let a user enter again
   * @return a valid integer
  */
  public static int getIntRange(){
    Scanner in = new Scanner(System.in);
    int num = 0;
    boolean valid = false;

    while (!valid){
      if ( in.hasNextInt() ){
        num = in.nextInt();
        if ((num >= LOW) && (num <= HIGH)){
          valid = true;
        }else{
          System.out.print("Input should be between 5 and 10. Enter again: ");
        }
      }else{
        in.next();
        System.out.print("Input should be an integer between 5 and 10. Enter again: ");
      }
    }
    return num;
  }
}