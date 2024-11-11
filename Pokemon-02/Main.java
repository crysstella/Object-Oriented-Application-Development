class Main {
  public static void main(String[] args) {
    System.out.println("Prof. Oak: Hello there new trainer, what is your name?");
    // get trainer's name
    String trainer_name = CheckInput.getString();
    System.out.println("Great to meet you, " + trainer_name);

    int level = 1;
    PokemonGenerator pg = PokemonGenerator.getInstance();
    Pokemon p;

    // get pokemon
    System.out.println("Choose your first pokemon: ");
    System.out.println("1. Charmander");
    System.out.println("2. Bulbasaur");
    System.out.println("3. Squirtle");
    int poke = CheckInput.getIntRange(1, 3);

    // load map
    int mapLevel = 0;
    Map map = Map.getInstance();
    map.loadMap(1);

    // Construct the trainer
    Trainer t;
    if (poke == 1) {
      p = pg.getPokemon("Charmander");
    } else if (poke == 2) {
      p = pg.getPokemon("Bulbasaur");
    } else {
      p = pg.getPokemon("Squirtle");
    }
    t = new Trainer(trainer_name, p);

    Pokemon wild = pg.generateRandomPokemon(1);
    p = new AttackUp(p);
    System.out.println(p.attack(wild, 2, 3));
/*
    // w and f while loop in main
    boolean onProcess = true;
    while (onProcess) {
      System.out.println(t);
      char ch = move(t);
      if (t.getHp() <= 0) {
        ch = '0';
      }
      switch (ch) {
        case 's':
          System.out.println("This is where I started");
          break;
        case 'f':
          // Defeat the gym leader
          Pokemon gym = pg.generateRandomPokemon(2); // a gym level +2
          System.out.println("A Gym Leader has appeared.");
          System.out.println(gym);

          int count = 0;
          boolean battle = true;
          while (battle) {
            if (t.getHp() <= 0) {
              battle = false;
              System.out.println(t.getName() + " has whited out...");
              break;
            }
            if (count == t.getNumPokemon()) {
              System.out.print("Your pokemons have no Hp left.");
              // has Potion
              if (t.hasPotion()) {
                System.out.println("You have some potions left, do you want to heal your pokemon? (Y/N)");
                boolean use = CheckInput.getYesNo();
                if (use) {
                  System.out.println("Choose a pokemon that you want to heal: ");
                  System.out.println(t.getPokemonList());
                  int tPoke = CheckInput.getIntRange(1, t.getNumPokemon()) - 1;
                  t.usePotion(tPoke);
                  break;
                } else {
                  battle = false;
                  randomMove(t);
                  System.out.println("You got away to another place. ");
                  break;
                }
              } else {
                randomMove(t);
                battle = false;
                System.out.println("You got away to another place. ");
                break;
              }
            }
            // Attack trainer's turn
            gym = trainerAttack(t, gym);

            if (gym.getHp() <= 0) {
              System.out.println("You beat the gym " + gym.getName());
              System.out.println("All your pokemons got buffed! ");
              t.buffAllPokemon();
              battle = false;
              Map.getInstance().removeCharAtLoc(t.getLocation());
              System.out.println("Head to next map");
              Map.getInstance().loadMap(++mapLevel % 3 + 1);
              level++;
              break;
            }
          }
          break;
        case 'n':
          System.out.println("Nothing here\n");
          break;
        case 'i':
          randomItem(t);
          break;
        case 'w':
          Pokemon wild = pg.generateRandomPokemon(level);
          System.out.println("A wild "+wild.getName()+" has appeared.");
          System.out.println(wild);

          boolean battle_w = true;
          while (battle_w){
            if (t.getHp() <= 0) {
              battle = false;
              System.out.println(t.getName() + " has whited out...");
              break;
            }
            Point loc = t.getLocation();
            int numPoke = t.getNumPokemon();
            wild = trainerAttack(t, wild);
            if (t.getNumPokemon() > numPoke ){
              System.out.println("Shake...Shake...Shake...");
              System.out.println("Gotcha!");
              System.out.println(wild.getName() + " was caught!");
              battle = false;
              break;
            }else if (t.getNumPokemon() == 7){
                System.out.println("You reached the maximum of 6 Pokemons, please remove a pokemon to add the new one: ");
                System.out.println(t.getPokemonList());
                int index = CheckInput.getIntRange(1, 7);
                Pokemon remove = t.removePokemon(index);
                System.out.println("You have removed " + remove.getName());
                System.out.println("Shake...Shake...Shake...");
                System.out.println("Gotcha!");
                System.out.println(wild.getName() + " was caught!");
                Map.getInstance().removeCharAtLoc(t.getLocation());
                battle = false;
                break;
            }else if (loc != t.getLocation()){
              battle = false;
              break;
            }
            if (wild.getHp() <= 0) {
              System.out.println("The wild " + wild.getName() + " fainted!");
              battle = false;
              Map.getInstance().removeCharAtLoc(t.getLocation());
              break;
            }
            System.out.println(wild);
          }
          break;
        case 'p':
          randomPerson(t);
          break;
        case 'c':
          onCity(t);
          break;
        case '0':
          System.out.println("Game Over");
          onProcess = false;
          break;
        default:
          System.out.println("You can't go that way.\n");
          break;
      }
    }*/
  }

  /**
   * Displays the menu option Get a player's input
   * 
   * @return a nunber of user's option
   */
  public static int mainMenu() {
    System.out.println("Main Menu: ");
    System.out.println("1. Go North");
    System.out.println("2. Go South");
    System.out.println("3. Go East");
    System.out.println("4. Go West");
    System.out.println("5. Quit");

    return CheckInput.getIntRange(1, 5);
  }

  /**
   * Find what's at trainer's location
   * 
   * @param t a trainer
   * @return a character at trainer's position
   */
  public static char move(Trainer t) {
    int move = mainMenu();

    if (move == 1) {
      return t.goNorth();
    } else if (move == 2) {
      return t.goSouth();
    } else if (move == 3) {
      return t.goEast();
    } else if (move == 4) {
      return t.goWest();
    }
    return '0';
  }

  public static void randomMove(Trainer t) {
    boolean moved = false;
    while (moved == false) {
      int ranMove = GenerateRandom.genIntBtw(1, 4);
      char c = '0';
      if (ranMove == 1) {
        c = t.goNorth();
      } else if (ranMove == 2) {
        c = t.goSouth();
      } else if (ranMove == 3) {
        c = t.goEast();
      } else if (ranMove == 4) {
        c = t.goWest();
      }
      if (c != 'x') {
        moved = true;
      }
    }
  }

  /**
   * Trainer's action when a wild pokemon appears: Fight/ Use Potion/ Throw Poke
   * Ball/ Run away.
   *
   * @param t    a trainer.
   * @param wild pokemon appears.
   * @author Keyi Wang
   */
  public static Pokemon trainerAttack(Trainer t, Pokemon wild) {
    if (Map.getInstance().getCharAtLoc(t.getLocation()) == 'f'){
      System.out.println("What do you want to do?\n" + "1. Fight\n" + "2. Use Potion");
      int input = CheckInput.getIntRange(1, 2);
      switch (input) {
        case 1:
          System.out.println("Choose a Pokemon: \n" + t.getPokemonList());
          int tPoke = CheckInput.getIntRange(1, t.getNumPokemon()) - 1;
          if (t.getPokemon(tPoke).getHp() <= 0) {
            int damage = GenerateRandom.genIntBtw(1, 5);
            t.takeDamage(damage);
            System.out.println("The pokemon is defeated.\nYou are injured by " + wild.getName() + " and takes " + damage
                + " damage.\n" + t.getName() + " HP: " + t.getHp() + "/" + t.getMaxHp() + "\n");
            break;
          }
          System.out.println(t.getPokemon(tPoke).getName() + ", I choose you! ");
          System.out.println(t.getPokemon(tPoke).getAttackTypeMenu());

          // trainer's turn
          int atkType = CheckInput.getIntRange(1, t.getPokemon(tPoke).getNumAttackTypeMenuItems());
          System.out.println(t.getPokemon(tPoke).getAttackMenu(atkType));
          int move = CheckInput.getIntRange(1, t.getPokemon(tPoke).getNumAttackMenuItems(atkType));
          // 10% chance an enemy pokemon debuff a trainer's pokemon
          int rand = GenerateRandom.genIntBtw(1, 100);
          if (rand <= 10) {
            t.debuffPokemon(tPoke);
          }
          System.out.println(t.getPokemon(tPoke).attack(wild, atkType, move));

          // enemy's turn
          atkType = GenerateRandom.genIntBtw(1, t.getPokemon(tPoke).getNumAttackTypeMenuItems());
          move = GenerateRandom.genIntBtw(1, t.getPokemon(tPoke).getNumAttackMenuItems(atkType));
          // 25% chance a trainer's pokemon debuff an enemy pokemon
          rand = GenerateRandom.genIntBtw(1, 100);
          if (rand <= 25) {
            System.out.println("Rand chance = " + rand);
            wild = PokemonGenerator.getInstance().addRandomDebuff(wild);
            System.out.println(wild.attack(t.getPokemon(tPoke), atkType, move));
          } else {
            System.out.println(wild.attack(t.getPokemon(tPoke), atkType, move));
          }
          System.out.println(wild);
          break;

        default: // Use potion
          if (t.hasPotion()) {
            System.out.println("Choose a pokemon to heal: ");
            System.out.println(t.getPokemonList());
            tPoke = CheckInput.getIntRange(1, t.getNumPokemon()) - 1;
            System.out.println("You used a potion on " + t.getPokemon(tPoke).getName() + ".");
            t.usePotion(tPoke);
            break;
          } else {
            System.out.println("You are out of potions!");
          }
          break;
      }
    }else{
      System.out.println(
          "What do you want to do?\n" + "1. Fight\n" + "2. Use Potion\n" + "3. Throw Poke Ball\n" + "4. Run Away");
      int input = CheckInput.getIntRange(1, 4);
      switch (input) {
        case 1:
          System.out.println("Choose a Pokemon: \n" + t.getPokemonList());
          int tPoke = CheckInput.getIntRange(1, t.getNumPokemon()) - 1;
          if (t.getPokemon(tPoke).getHp() <= 0) {
            int damage = GenerateRandom.genIntBtw(1, 5);
            t.takeDamage(damage);
            System.out.println("The pokemon is defeated.\nYou are injured by " + wild.getName() + " and takes " + damage
                + " damage.\n" + t.getName() + " HP: " + t.getHp() + "/" + t.getMaxHp() + "\n");
            break;
          }
          System.out.println(t.getPokemon(tPoke).getName() + ", I choose you! ");
          System.out.println(t.getPokemon(tPoke).getAttackTypeMenu());

          // trainer's turn
          int atkType = CheckInput.getIntRange(1, t.getPokemon(tPoke).getNumAttackTypeMenuItems());
          System.out.println(t.getPokemon(tPoke).getAttackMenu(atkType));
          int move = CheckInput.getIntRange(1, t.getPokemon(tPoke).getNumAttackMenuItems(atkType));
          // 10% chance an enemy pokemon debuff a trainer's pokemon
          int rand = GenerateRandom.genIntBtw(1, 100);
          if (rand <= 10) {
            t.debuffPokemon(tPoke);
          }
          System.out.println(t.getPokemon(tPoke).attack(wild, atkType, move));

          // enemy's turn
          atkType = GenerateRandom.genIntBtw(1, t.getPokemon(tPoke).getNumAttackTypeMenuItems());
          move = GenerateRandom.genIntBtw(1, t.getPokemon(tPoke).getNumAttackMenuItems(atkType));
          // 25% chance a trainer's pokemon debuff an enemy pokemon
          rand = GenerateRandom.genIntBtw(1, 100);
          if (rand <= 25) {
            wild = PokemonGenerator.getInstance().addRandomDebuff(wild);
            System.out.println(wild.attack(t.getPokemon(tPoke), atkType, move));
          } else {
            System.out.println(wild.attack(t.getPokemon(tPoke), atkType, move));
          }
          break;
          
        case 2:
          if (t.hasPotion()) {
            System.out.println("Choose a pokemon to heal: ");
            System.out.println(t.getPokemonList());
            tPoke = CheckInput.getIntRange(1, t.getNumPokemon()) - 1;
            System.out.println("You used a potion on " + t.getPokemon(tPoke).getName() + ".");
            t.usePotion(tPoke);
            break;
          } else {
            System.out.println("You are out of potions!");
            break;
          }
        case 3: // make chance
          if (t.hasPokeball()){
            if (t.catchPokemon(wild)){
              break;  
            }else{
              System.out.println("Shake...Shake...");
              System.out.println(wild.getName() + " broke free!");
              break;
            }
          }else{
            System.out.println("You are out of Poke Balls!");
            break;
          }
          /*if (t.hasPokeball()) {
            if (t.catchPokemon(wild)) {
              System.out.println("Shake...Shake...Shake...");
              System.out.println("Gotcha!");
              System.out.println(wild.getName() + " was caught!");
              // if t.Poke num differs from before battle = false;
              Map.getInstance().removeCharAtLoc(t.getLocation());
              break;
            } else {
              if (t.getNumPokemon() > 6){
                System.out.println("You have reached the maximum of 6 Pokemons, please remove a pokemon to add the new one: ");
                System.out.println(t.getPokemonList());
                int i = CheckInput.getIntRange(1, 7);
                Pokemon remove = t.removePokemon(i);
                return remove;
                if (t.catchPokemon(wild)){
                  System.out.println("Shake...Shake...Shake...");
                  System.out.println("Gotcha!");
                  System.out.println(wild.getName() + " was caught!");
                  Map.getInstance().removeCharAtLoc(t.getLocation());
                  break;
                }
              }
              System.out.println("Shake...Shake...");
              System.out.println(wild.getName() + " broke free!");
              break;
            }
          }else {
            System.out.println("You are out of Poke Balls!");
            break;
          }*/

        case 4:
          System.out.println("You got away saftely!");
          randomMove(t);
          break;

        default:
          System.out.println("Invalid option");
          break;
      }
    }

    return wild;
  }

  /**
   * A trainer enters the store to get some potions or poke balls if needed.
   * 
   * @param t a trainer.
   */
  public static void store(Trainer t) {
    boolean onStore = true;
    int moneyBefore = t.getMoney();
    while (onStore) {
      System.out.println("Hello! What can I help you with?\n" + "1. Buy Potions - $5\n" + "2. Buy Poke Balls - $3\n"
          + "3. Exit\n" + "Money: " + t.getMoney());

      switch (CheckInput.getIntRange(1, 3)) {
        case 1:
          if (t.spendMoney(5)) {
            System.out.println("Here's your potion");
            t.receivePotion();
          } else {
            System.out.println("You do not have enough money");
          }
          break;
        case 2:
          if (t.spendMoney(3)) {
            System.out.println("Here's your Poke ball");
            t.receivePokeball();
          } else {
            System.out.println("You do not have enough money");
          }
          break;
        case 3:
          if (moneyBefore == t.getMoney()) {
            System.out.println("Get out !!!");
          } else {
            System.out.println("Thank you, come again soon!");
          }
          onStore = false;
          break;
      }
    }
  }

  /**
   * Random item to give a trainer as a gift or attacks some damage to a trainer.
   * 
   * @param t a trainer who receives a random item
   */
  public static void randomItem(Trainer t) {
    int ran = GenerateRandom.genIntBtw(1, 3);
    switch (ran) {
      case 1:
        int ranMoney = GenerateRandom.genIntBtw(10, 20);
        t.receiveMoney(ranMoney);
        System.out.println("Found some old coins in the trash. " + ranMoney + " coins are added to the bag");
        break;
      case 2:
        System.out.println("Someone failed to catch a pokemon, and threw the poke ball away. Poke ball +1");
        t.receivePokeball();
        break;
      case 3:
        System.out
            .printf("Found a used potion. There is a little fuild remained inside the bottle. Still useful.　Potion +1");
        t.receivePotion();
        break;

      // I think we just give random items only
      /*
       * case 4: System.out.println(
       * "Found an injured pokemon sitting on the bench. Do you wanna put it into the bag? (Yes/No)"
       * ); if (CheckInput.getYesNo()){ int pokeSize = t.getNumPokemon(); if (pokeSize
       * < 7){
       * System.out.println("You healed it and put it into the bag. Pokemon +1"); //
       * add pokemon
       * 
       * }else{ System.out.
       * println("You have reached the maximum of 6 Pokemons, please remove a pokemon to add the new one: "
       * ); System.out.println(t.getPokemonList()); int remove =
       * CheckInput.getIntRange(1, pokeSize); Pokemon pRemove =
       * t.removePokemon(remove-1); // add pokemon } //add pokemon Pokemon addP =
       * chooseRandomPokemon();
       * 
       * }
       */
      default:
        break;
    }
    Map.getInstance().removeCharAtLoc(t.getLocation());
  }

  /**
   * Random person that the trainer encounters This person can give the trainer
   * items, money, or can cause * them damage.
   * 
   * @param t a trainer
   */
  public static void randomPerson(Trainer t) {
    int ran = GenerateRandom.genIntBtw(1, 4);
    switch (ran) {
      case 1:
        int ranMoney = GenerateRandom.genIntBtw(10, 20);
        t.receiveMoney(ranMoney);
        System.out.println("Hi " + t.getName() + ", nice to meet you! I'll give you " + ranMoney
            + " for your travels. Save it and stay safe!!\n");
        break;

      case 2:
        System.out.println("I'm looking for something to give you a gift.....");
        t.receivePotion();
        System.out.println("Ahhh, you should take this potion to heal. Good luck!" + " Potions +1\n");
        break;

      case 3:
        t.receivePokeball();
        System.out.println("Hey " + t.getName()
            + ". I suddenly found the poke ball that someone dropped. I don't need it, so I give it to you. Be aware when using it! Poke ball +1\n");
        break;

      default:
        System.out.println("Hey, how dare you get in my territory!!!!!!\n");
        int damage = GenerateRandom.genIntBtw(1, 10);
        t.takeDamage(damage);
        System.out.println("The person attacked you " + damage + " damage.\n");
        break;
    }
    Map.getInstance().removeCharAtLoc(t.getLocation());
  }

  /**
   * A trainer enters the city to shop or go to hospital
   * 
   * @param t a trainer
   */
  public static void onCity(Trainer t) {
    System.out.println("You've entered the city.");
    System.out.println("Where would you like to go?\n" + "1. Store\n" + "2. Pokemon Hospital");
    switch (CheckInput.getIntRange(1, 2)) {
      case 1:
        store(t);
        break;
      case 2:
        t.healAllPokemon();
        break;
    }
  }
}