/** Stellar Nguyen
  * Matthew Kriesel
  * 10/04/2021
  * Dragon Trainer
*/

class Main {
  public static void main(String[] args) {
    int hp = 50;
    int tool;
    int dragChoose;
    int playerDame;
    int dragDame;
    int randAttack;
    boolean dragDie[] = {false, false, false};
    String name;
 
    Dragon drag1 = new Dragon("Deadly Nadder", 10);
    FireDragon drag2 = new FireDragon("Gronckle", 15);
    FlyingDragon drag3 = new FlyingDragon("Timberjack", 20);
    
    System.out.println("What is your name, challenger?");
    name = CheckInput.getString();
    System.out.println("Welcome to dragon training, " + name);
    System.out.println("You must defeat 3 dragons.");

    while ((hp > 0) && ((drag1.getHp() > 0) |(drag2.getHp() > 0) | (drag3.getHp() > 0))){
      System.out.println("\n" + name +  " HP: " + hp);

      if(drag1.getHp() > 0){
        System.out.println("1. " + drag1);
      }
      if (drag2.getHp() > 0){
        System.out.println("2. " + drag2);
      }
      if (drag3.getHp() > 0){
        System.out.println("3. " + drag3);
      }

      dragChoose = CheckInput.getIntRange(1, 3);
      while (dragDie[dragChoose-1]){
        System.out.println("The dragon has been defeated. Choose another dragon!");
        dragChoose = CheckInput.getInt();
      }
       
      System.out.println("Attack with: ");
      System.out.println("1. Arrow (1 D12)"); // 1-12
      System.out.println("2. Sword (2 D6)");  // 1-6 + 1-6

      tool = CheckInput.getIntRange(1, 2);
      if (tool == 1){
        System.out.println("You hit the dragon with an arrow. ");
        playerDame = (int)(Math.random()*12) + 1;
      }else{
        System.out.println("You slash the dragon with your sword.");
        playerDame = ((int)(Math.random()*6) + 1) + ((int)(Math.random()*6) + 1);
      }

      /**If randAttack = 1 -> basic attack
        *If randAttack = 2 -> special attack
      */
      if (dragChoose == 1){
        drag1.takeDamage(playerDame);
        if (drag1.getHp() == 0){ dragDie[0] = true; } 
        dragDame = drag1.attack();
        hp -= dragDame;
        if ((drag1.getHp() == 0) && (drag2.getHp() == 0) && (drag3.getHp() == 0)){
          break;
        }
        System.out.println(drag1.getName() + " smashes you with its tail.");   
      }else if (dragChoose == 2){
        randAttack = (int)Math.random()*2 + 1;
        drag2.takeDamage(playerDame);
        if (drag2.getHp() == 0){ dragDie[1] = true; }
        if ((drag1.getHp() == 0) && (drag2.getHp() == 0) && (drag3.getHp() == 0)){
          break;
        }
        if (randAttack == 2){
          dragDame = drag2.fireShot();
          hp -= dragDame;
          System.out.println(drag2.getName() + " spews fire at you.");
        }else{
          dragDame = drag2.attack();
          hp -= dragDame;
          System.out.println(drag2.getName() + " smashes you with its tail.");   
        }
      }else{
        randAttack = (int)(Math.random()*2) + 1;
        drag3.takeDamage(playerDame);
        if (drag3.getHp() == 0){ dragDie[2] = true; }   
        if ((drag1.getHp() == 0) && (drag2.getHp() == 0) && (drag3.getHp() == 0)){
           break;
        }
        if (randAttack == 2){
          dragDame = drag3.swoopAttack();
          hp -= dragDame;
          System.out.println(drag3.getName() + " swoops down and knocks you over.");
          
        }else{
          dragDame = drag3.attack();
          hp -= dragDame;
          System.out.println(drag3.getName() + " smashes you with its tail.");
        }
      }
    }

    if (hp <= 0){
        System.out.println("\nYou lose! The dragons defeat you!");
    }else{
      System.out.println("\nCongratulations " + name + "!");
      System.out.println("You defeated all three dragons.\nYou win!");
    }
  }    
};