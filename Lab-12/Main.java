class Main {
  public static void main(String[] args) {
    int hp = 25;
    int maxHp = 25;
    EnemyGenerator eGen = new EnemyGenerator();
    int count = 0;
    int inp = 0;
    boolean playing = true;

    while (playing){
      // Create an Enemy.
      Enemy e = eGen.generateEnemy();
      
      while (true){
        // Check a user's input.      
        System.out.printf("\nYou have %d/%d hp.\n", hp, maxHp);
        System.out.println("You encounter a " + e);
        System.out.println("What do you want to do?\n"
                          + "1. Attack Enemy\n" 
                          + "2. Quit");
        inp = CheckInput.inRange(1,2);
        if (inp == 2){
          System.out.println("You quit the game.");
          playing = false;
          break;
        }
      
        // You attack enemy. 
        if (hp > 0){
          int damage = (int) (Math.random()*5);
          e.takeDamage(damage);
          System.out.println("You attack " + e.getName() + " for " + damage + " damage.");
        }else{
          playing = false;
          break;
        }

        // Enemy fights against.
        if (e.getHp() > 0){
          int damage = e.attack();
          hp -= damage;
          System.out.println(e.getName() + " attacks you for " + damage + " damage.");
          
          if (hp <= 0){
            System.out.println("You have died.");
            playing = false;
            break;
          }
        }else{
          count++;
          System.out.println("You have slain the " + e.getName() + ".");
          break;
        }
      }
    }
    
    // Game Over.
    System.out.println("Enemies Slain: " + count);
    if (hp <= 0){
      System.out.println("Game Over.");
    }

  }
}