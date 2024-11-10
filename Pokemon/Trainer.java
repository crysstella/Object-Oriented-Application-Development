import java.util.ArrayList;
/**
 * A trainer object who controls the pokemon has name, hp, money, potions,
 * poke balls, some own pokemons, and locations in the map.
 *
 * @author Vo Nguyen
 */

public class Trainer extends Entity {
	private int money;
	private int potions;
	private int pokeballs;
	private Point loc;
	private Map map;
	private ArrayList <Pokemon> pokemon;

  /**
   * Constructor creates new trainer 
   * with name, hp, money, potions, pokeballs, and initial location in a map
   * and adding chosen pokemon.
   * @param n trainer's name.
   * @param p pokemon of the trainer.
   * @param m map track for trainer.
  */
	public Trainer(String n, Pokemon p, Map m){
		super(n, GenerateRandom.genIntBtw(20, 25));
    pokemon = new ArrayList<Pokemon>();
    pokemon.add(p);
		money = GenerateRandom.genIntBtw(20, 25);
		potions = GenerateRandom.genIntBtw(1, 3);
		pokeballs = GenerateRandom.genIntBtw(3, 5);
		map = m;
		loc = map.findStart();
    	//loc = new Point(m.findStart().getX(), m.findStart().getY());
	}

  /**
   * Retrieve money's value.
   * @return money's value that trainer has.
   */
	public int getMoney(){
    	return money;
	}

  /**
   * Checking if money is enough to spend
   * If it's enough, let a trainer use money.
   * @param amt cost of an item.
   * @return true if money is enough to buy an item
   * or false if money is not enough to buy an item.
   */
  public boolean spendMoney(int amt){
    if (money < amt){
      return false;
    }
    money -= amt;
    return true;
  }

  /**
   * Modify money's value by a specific amount.
   * @param amt the amount receive.
   */
  public void receiveMoney(int amt){
    money += amt;
  }

  /**
   * Checking if potion is available to use.
   * @return true if it is available or false if it is not.
   */
  public boolean hasPotion(){
    return potions > 0 ? true : false;
  }

  /**
   * Modify potion's amount by 1.
   */
  public void receivePotion(){
    potions ++;
  }

  /**
   * Using a potion to heal a Pokemon.
   * @param pokeIndex index of Pokemon list.
   */
  public void usePotion(int pokeIndex){
      potions--;
      pokemon.get(pokeIndex).heal();
  }

  /**
   * Checking if poke ball is available to use.
   * @return true if it is available or false if it is not.
   */
  public boolean hasPokeball(){
    return pokeballs > 0 ? true : false;
  }

  /**
   * Modify potion's amount by 1.
   */
  public void receivePokeball(){
    pokeballs++;
  }

  /**
   * Checking if catchPokemon works by checking hasPokeball().
   * @param p a pokemon that a trainer wants to catch.
   * @return true if it works or false it does not.
   */
  public boolean catchPokemon(Pokemon p){
    if (hasPokeball()){
      int ran = GenerateRandom.genIntBtw(1,100);
      if (ran >= (p.getHp()*100 / p.getMaxHp())){
         pokemon.add(p);
         pokeballs--;
         return true;      
      } 
    }
    return false;
  }

  /**
   * Retrieve the location of the trainer.
   * @return current location of the trainer.
   */
  public Point getLocation(){
    return (loc);
  }

  /**
   * Updating trainer's location when moving to the North.
   * @return the character at a current location.
   */
  public char goNorth(){
    char ch1 = map.getCharAtLoc(loc);
    if (ch1 != 'x'){
      map.reveal(loc);
    }

    loc.setX(loc.getX()-1);
    char ch = map.getCharAtLoc(loc);
    if (ch == 'x'){
      loc.setX(loc.getX()+1);
    }
    
    return ch;
  }

  /**
   * Updating trainer's location when moving to the North.
   * @return the character at a current location.
   */  
  public char goSouth(){
    char ch1 = map.getCharAtLoc(loc);
    if (ch1 != 'x'){
      map.reveal(loc);
    }

    loc.setX(loc.getX()+1);
    char ch = map.getCharAtLoc(loc);
    if (ch == 'x'){
      loc.setX(loc.getX()-1);
    }
    return ch;
  }

  /**
   * Updating trainer's location when moving to the North.
   * @return the character at a current location.
   */
  public char goEast(){
    char ch1 = map.getCharAtLoc(loc);
    if (ch1 != 'x'){
      map.reveal(loc);
    }

    loc.setY(loc.getY() + 1);
    char ch = map.getCharAtLoc(loc);
    if (ch == 'x'){
      loc.setY(loc.getY()-1);
    }
    return ch;
  }

  /**
   * Updating trainer's location when moving to the North.
   * @return the character at a current location.
   */
  public char goWest(){
    char ch1 = map.getCharAtLoc(loc);
    if (ch1 != 'x'){
      map.reveal(loc);
    }
    
    loc.setY(loc.getY()-1);
    char ch = map.getCharAtLoc(loc);
    if (ch == 'x'){
      loc.setY(loc.getY() + 1);
    }
    return ch;

  }

  /**
   * Retrieve a number of pokemons that a trainer is having.
   * @return a number of pokemons in pokemon list.
   */
  public int getNumPokemon(){
    return pokemon.size();
  }

  /**
   * Healing all pokemon that a trainer is having.
   */
  public void healAllPokemon(){
    for (int i = 0; i < pokemon.size(); i++){
       pokemon.get(i).heal();
    }
  }

  /**
   * Retrieve a specific pokemon.
   * @param index index of pokemon in pokemon list.
   * @return a pokemon at index. 
   */
  public Pokemon getPokemon(int index){
    return pokemon.get(index);
  }

  /**
   * Display all pokemons that a trainer is having.
   * @return the list of pokemons.
   */
  public String getPokemonList(){
    String poke = "";
    for (int i = 0; i < pokemon.size(); i++){
      poke += (i+1) + ". " + pokemon.get(i).toString() + "\n";
    }
    return poke;
  }

  /**
   * Retrieve the map.
   * @return the map.
   */
	public Map getMap() {
		return map;
	}

  /**
   * Adding a new pokemon to the pokemon list.
   * @param p a pokemon that a trainer wants to add.
   */
	public void addPokemon(Pokemon p) {
		pokemon.add(p);
	}
  
  /**
   * Display trainer's name, HP, money, potions, poke balls,
   * and all the pokemons that the trainer has;
   * Display current location of the trainer in the map.
   * @return a String of all trainer's information.
   */
  @Override
  public String toString(){
    String name = super.toString();
    String info = "Money: " + money + 
                  "\nPotions: " + potions + 
                  "\nPoke Balls: " + pokeballs + 
                  "\n";
    String poke = "Pokemon\n-------\n" + 
                  getPokemonList();

    return name + info + poke + map.mapToString(loc);
  }
  
}