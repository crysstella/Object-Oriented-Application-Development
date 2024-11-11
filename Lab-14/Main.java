/**
 * Vo Nguyen
 * Matthew Kriesel
 * 
 * Date: 12/08/2021
 *
 * Puppy Simulator using State Pattern with two functions: feed or play with the puppy
 * A puppy has three states: asleep, eating, or playing.
 *
 */
class Main {
  public static void main(String[] args) {
    Puppy p = new Puppy();
    System.out.println("Congratulations on your new puppy!");
    int inp = 0;

    while (true){
      System.out.println("What would you like to do?");
      System.out.println("1.Feed\n2. Play\n3. Quit");
      inp = CheckInput.getIntRange(1, 3);

      if (inp == 1){
        System.out.println(p.giveFood());
      }else if (inp == 2){
        System.out.println(p.throwBall());
      }else if (inp == 3){
        break;
      }
      
    }
  }
}