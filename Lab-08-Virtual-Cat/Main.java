/** Stellar Nguyen
  * Matthew Kriesel
  * 10/13/2021
  * Virtual Cat
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner inp = new Scanner (System.in);
    String name = "";
    int choice = 0;
    boolean playing = true;

    System.out.println("Choose a kitty: ");
    System.out.println("1. Tabby Cat\n2. Ocelot\n3. Tiger");
    choice = getIntRange(1, 3);
    System.out.print("Name your kitty: ");
    name = inp.nextLine().trim();

    Player p = new Player();
    Cat c;

    if (choice == 1){
      c = new Tabby(name);
    }else if (choice == 2){
      c = new Ocelot(name);
    }else{
      c = new Tiger(name);
    }

    while (playing){
      interactCat(c, p);
      if (p.getHp() == 0){
        playing = false;
      }
    }

    System.out.println("\nGame Over.");
  }

  /**Displays the player and cat.
   * Displays the cat interaction menu
   * Get the user's input
   * Displays the interaction string
   * @param c the cat player chooses
   * @param p the player
  */
  public static void interactCat(Cat c, Player p){
    System.out.print(p);
    System.out.println(c);
    menu();

    int interact = 0;
    interact = getIntRange(1, 3);
    
    switch (interact){
      case 1: 
        System.out.println(c.feed(p));
        break;
      case 2:
        System.out.println(c.play(p));
        break;
      default:
        System.out.println(c.pet(p));
        break;
    }

  }

  /**
	 * Checks if the inputted value is an integer and 
	 * within the specified range (ex: 1-10)
	 * @param low lower bound of the range.
	 * @param high upper bound of the range.
	 * @return the valid input.
	 */
  public static int getIntRange(int low, int high){
    Scanner inp = new Scanner (System.in);
    int input = 0;
    boolean valid = false;

    while (!valid){
      if (inp.hasNextInt()){
        input = inp.nextInt();
        if ((input >= low) && (input <= high)){
          valid = true;
        }else{
          System.out.println("Invalid Range.");
        }
      }else{
        inp.next();
        System.out.println("Invalid Input.");
      }
    }

    return input;
  }

  /**Displays user's choice
  */
  public static void menu(){
    System.out.println("1. Feed your cat");
    System.out.println("2. Play with your cat");
    System.out.println("3. Pet your cat");
  }
}