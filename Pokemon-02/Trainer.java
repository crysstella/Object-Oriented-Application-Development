import java.util.ArrayList;

public class Trainer extends Entity{
  private int money;
	private int potions;
	private int pokeballs;
	private Point loc;
	private ArrayList <Pokemon> pokemon;

  public Trainer(String n, Pokemon p){
    super(n, 25, 25);
    pokemon = new ArrayList<Pokemon>();
    pokemon.add(p);
    money = GenerateRandom.genIntBtw(20, 25);
		potions = GenerateRandom.genIntBtw(1, 3);
		pokeballs = GenerateRandom.genIntBtw(3, 5);
		loc = Map.getInstance().findStart();
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
   * @return true if money is enough to buy an item.
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
      Pokemon p = pokemon.get(pokeIndex);
      pokemon.set(pokeIndex, PokemonGenerator.getInstance().addRandomBuff(p));
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
    int ran = GenerateRandom.genIntBtw(1,100);
    if (ran >= (p.getHp()*100 / p.getMaxHp())){
         pokemon.add(p);
         pokeballs--;
         return true;      
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
    char ch1 = Map.getInstance().getCharAtLoc(loc);
    if (ch1 != 'x'){
      Map.getInstance().reveal(loc);
    }

    loc.setX(loc.getX()-1);
    char ch = Map.getInstance().getCharAtLoc(loc);
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
    char ch1 = Map.getInstance().getCharAtLoc(loc);
    if (ch1 != 'x'){
      Map.getInstance().reveal(loc);
    }

    loc.setX(loc.getX()+1);
    char ch = Map.getInstance().getCharAtLoc(loc);
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
    char ch1 = Map.getInstance().getCharAtLoc(loc);
    if (ch1 != 'x'){
      Map.getInstance().reveal(loc);
    }

    loc.setY(loc.getY() + 1);
    char ch = Map.getInstance().getCharAtLoc(loc);
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
    char ch1 = Map.getInstance().getCharAtLoc(loc);
    if (ch1 != 'x'){
      Map.getInstance().reveal(loc);
    }
    
    loc.setY(loc.getY()-1);
    char ch = Map.getInstance().getCharAtLoc(loc);
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

  public void buffAllPokemon(){
    healAllPokemon();
    PokemonGenerator gen = PokemonGenerator.getInstance();
    for (int i = 0; i < pokemon.size(); i++){
      Pokemon p = pokemon.get(i);
      pokemon.set(i, gen.addRandomBuff(p));
    }
  }

  public void debuffPokemon(int index){
    PokemonGenerator gen = PokemonGenerator.getInstance();
    Pokemon p = pokemon.get(index);
    pokemon.set(index, gen. addRandomDebuff(p));
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

  public Pokemon removePokemon(int index){
    Pokemon p = pokemon.get(index);
    pokemon.remove(index);
    return p;
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

    return name + info + poke +  Map.getInstance().mapToString(loc);
  }

}