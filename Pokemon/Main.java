import java.io.*;
import java.util.ArrayList;
import java.lang.String;

/**
 * Project 1 Pokemon Game Date: 10/25/2021
 * 
 *
 * @author Stellar Nguyen
 * @author Matthew Kriesel
 * @author Keyi Wang
 */

public class Main {
  public static void main(String[] args) {
    System.out.println("Prof. Oak: Hello there new trainer, what is your name?");

    // get trainer's name
    String trainer_name = CheckInput.getString();
    System.out.println("Great to meet you, " + trainer_name);

    // get pokemon
    System.out.println("Choose your first pokemon: ");
    System.out.println("1. Charmander");
    System.out.println("2. Bulbasaur");
    System.out.println("3. Squirtle");
    int poke = CheckInput.getIntRange(1, 3);
    Pokemon p;

    // load map
    int mapLevel = 0;
    Map map = new Map();
    map.loadMap(1);

    // construct the trainer
    Trainer t;
    if (poke == 1) {
      p = new Charmander();
    } else if (poke == 2) {
      p = new Bulbasaur();
    } else {
      p = new Squirtle();
    }
    t = new Trainer(trainer_name, p, map);

    boolean onProcess = true;
    while (onProcess) {
      System.out.println(t.toString());
      char ch = move(t);
      if (t.getHp() <= 0) {
        ch = '0';
      }
      switch (ch) {
        case 's':
          System.out.println("This is where I started");
          break;
        case 'f':
          System.out.println("Head to next map");
          t.getMap().loadMap(++mapLevel % 3 + 1);
          break;
        case 'n':
          System.out.println("Nothing here\n");
          break;
        case 'i':
          randomItem(t);
          break;
        case 'w':
          trainerAttack(t, chooseRandomPokemon());
          map.removeCharAtLoc(t.getLocation());

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
    }
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
   * @author Vo Nguyen
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

  /**
   * Generate random pokemon.
   * 
   * @return a random pokemon.
   * @author Vo Nguyen
   */
  public static Pokemon chooseRandomPokemon() {
    Pokemon b = new Bulbasaur();
    Pokemon c = new Charmander();
    Pokemon o = new Oddish();
    Pokemon po = new Ponyta();
    Pokemon sq = new Squirtle();
    Pokemon st = new Staryu();

    ArrayList<Pokemon> pList = new ArrayList<Pokemon>();
    pList.add(b);
    pList.add(c);
    pList.add(o);
    pList.add(po);
    pList.add(sq);
    pList.add(st);

    int rand = GenerateRandom.genIntBtw(0, pList.size() - 1);
    return pList.get(rand);
  }

  /**
   * Trainer's action when a wild pokemon appears: Fight/ Use Potion/ Throw Poke
   * Ball/ Run away.
   *
   * @param t    a trainer.
   * @param wild pokemon appears.
   * @author Keyi Wang
   */
  public static void trainerAttack(Trainer t, Pokemon wild) {
    System.out.println("A wild " + wild.getName() + " has appeared.");
    System.out.println(wild.toString());
    boolean battle = true;
    while (battle) {
      System.out.println(
          "What do you want to do?\n" + "1. Fight\n" + "2. Use Potion\n" + "3. Throw Poke Ball\n" + "4. Run Away");
      if (t.getHp() <= 0) {
        battle = false;
        System.out.println(t.getName() + " has whited out...");
        break;
      }
      switch (CheckInput.getIntRange(1, 4)) {
        case 1:
          System.out.println("Choose a Pokemon: \n" + t.getPokemonList());
          int tPoke = CheckInput.getIntRange(1, t.getNumPokemon()) - 1;
          if (t.getPokemon(tPoke).getHp() <= 0) {
            t.takeDamage(GenerateRandom.genIntBtw(1, 5));
            break;
          }
          System.out.println(t.getPokemon(tPoke).getName() + ", I choose you! ");
          System.out.println(t.getPokemon(tPoke).getAttackMenu());

          // trainer's turn
          int move = CheckInput.getIntRange(1, t.getPokemon(tPoke).getNumAttackMenuItems());
          if (move == 1) {
            System.out.println(t.getPokemon(tPoke).getBasicMenu());
            move = CheckInput.getIntRange(1, t.getPokemon(tPoke).getNumBasicMenuItems());
            System.out.println(t.getPokemon(tPoke).basicAttack(wild, move));
          } else {
            System.out.println(t.getPokemon(tPoke).getSpecialMenu());
            move = CheckInput.getIntRange(1, t.getPokemon(tPoke).getNumSpecialMenuItems());
            System.out.println(t.getPokemon(tPoke).specialAttack(wild, move));
          }

          // enemy's turn
          move = GenerateRandom.genIntBtw(1, t.getPokemon(tPoke).getNumAttackMenuItems());
          if (move == 1) {
            move = GenerateRandom.genIntBtw(1, t.getPokemon(tPoke).getNumBasicMenuItems());
            System.out.println(wild.basicAttack(t.getPokemon(tPoke), move));
          } else {
            move = GenerateRandom.genIntBtw(1, t.getPokemon(tPoke).getNumSpecialMenuItems());
            System.out.println(wild.specialAttack(t.getPokemon(tPoke), move));
          }
          if (wild.getHp() <= 0) {
            System.out.println("The wild " + wild.getName() + " fainted!");
            battle = false;
            t.getMap().removeCharAtLoc(t.getLocation());
            break;
          }

          System.out.println(wild.toString());
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
          if (t.hasPokeball()) {
            if (t.catchPokemon(wild)) {
              System.out.println("Shake...Shake...Shake...");
              System.out.println("Gotcha!");
              System.out.println(wild.getName() + " was caught!");
              battle = false;
              t.getMap().removeCharAtLoc(t.getLocation());
              break;
            } else {
              System.out.println("Shake...Shake...");
              System.out.println(wild.getName() + " broke free!");
              break;
            }
          } else {
            System.out.println("You are out of Poke Balls!");
            break;
          }
        case 4:
          System.out.println("You got away saftely!");
          battle = false;
          boolean moved = false;
          while (moved == false) {
            int ranMove = GenerateRandom.genIntBtw(1, 4);
            System.out.println("ran Move = " + ranMove);
            char ch = '0';
            if (ranMove == 1) {
              ch = t.goNorth();
            } else if (ranMove == 2) {
              ch = t.goSouth();
            } else if (ranMove == 3) {
              ch = t.goEast();
            } else if (ranMove == 4) {
              ch = t.goWest();
            }

            if (ch != 'x') {
              moved = true;
            }

            System.out.println("moved = " + moved);
          }
          break;

        default:
          System.out.println("Invalid option");
          break;

      }
    }
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
      case 4:
        System.out.println(
            "Found an injured pokemon sitting on the bench. You healed it and put it into the bag. Pokemon +1");
        t.addPokemon(chooseRandomPokemon());
      default:
        break;
    }
    t.getMap().removeCharAtLoc(t.getLocation());
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
    t.getMap().removeCharAtLoc(t.getLocation());
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