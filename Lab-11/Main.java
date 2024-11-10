/**
 * Matthew Kriesel
 * Stellar Nguyen
 * 11/10/2021
 * Create a program that allows the user to select a Ball object with 
 * different colors that the user can play with (bounce or roll).
 */

class Main {
  public static void main(String[] args) {
    Ball ball;
    int user = 0;

    while (true){
      System.out.println("Choose a ball color (q to quit): ");
      String c = CheckInput.getString();
      if (c.equalsIgnoreCase("q")){
        break;
      }
      ball = Ball.getInstance(c);
      
      System.out.println("1. Roll ball\n2. Bounce ball");
      user = CheckInput.getIntRange(1, 2);

      if (user == 1){
        ball.roll();
        System.out.println("\nYou roll the " + c + " ball.");
      }else if (user == 2){
        ball.bounce();
        System.out.println("You bounce the " + c + " ball.");
      }

      System.out.println("\n"+ ball);
    }
  }
}