/** Stellar Nguyen
  * Matthew Kriesel
  * 09/27/2021
  * Creates a dice game.
*/
class Main {
  public static void main(String[] args) {
    boolean process = true;
    Player p = new Player();

    System.out.print("\nYahtzee\n\n");
    
    while (process){
      p.roll();
      System.out.println("Rolling Dice..."+ p);
      if (p.threeOfAKind()){
        System.out.println("You got 3 of a kind!");
      }else if (p.pair()){
        System.out.println("You got a pair!");
      }else if (p.series()){
        System.out.println("You got a series of 3!");
      }else{
        System.out.println("Awww. Too Bad.");
      }
      System.out.println("Score = " + p.getPoints() + " points.");
      System.out.println("Play again? (Y/N) ");
        process = CheckInput.getYesNo();
    }

    System.out.println("Game Over.");
    System.out.printf("Final Score = %d points", p.getPoints());
  }
}