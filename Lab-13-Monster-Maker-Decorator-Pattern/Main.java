class Main {
  public static void main(String[] args) {
    System.out.println("Monster Creator!");
    System.out.println("Choose a base monster: \n1. Alien\n2. Beast\n3. Undead");
    int input = CheckInput.getIntRange(1, 3);
    Monster monster = null;
    if (input == 1){
      monster = new Alien();
    }else if (input == 2){
      monster = new Beast();
    }else if (input == 3){
      monster = new Undead();
    }
    
    while (input != 5){
      System.out.println(monster.getName() + "has " + monster.getHp() + " hp, and attacks for " + monster.attack() + " damage. ");
      System.out.println("Add an ability:\n1. Fire\n2. Flying\n3. Lasers\n4. Poison\n5. Quit");
      input = CheckInput.getIntRange(1, 5);
      switch (input){
        case 1: 
          monster = new Fire(monster);
          break;
        case 2: 
          monster = new Flying(monster);
          break;
        case 3:
          monster = new Lasers(monster);
          break;
        case 4: 
          monster = new Poison(monster);
          break;
        default: 
          System.out.println("Exiting");
          break;
      }
                          
    }

  }
}