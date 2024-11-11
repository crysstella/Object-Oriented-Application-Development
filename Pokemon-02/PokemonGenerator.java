
import java.util.*;
import java.io.*;

public class PokemonGenerator{
  private HashMap<String, String> pokemon = new HashMap<String, String>();
  private static PokemonGenerator instance = null;

  private PokemonGenerator(){
    try{
      Scanner read = new Scanner(new File("PokemonList.txt"));
      while (read.hasNextLine()){
        String line = read.nextLine();
        String [] tokens = line.split(",");
        tokens[0] = tokens[0].trim();
		    pokemon.put(tokens[0], tokens[1]);
      }
    }catch (FileNotFoundException ex){
      System.out.println("FNF!");
    }
  }

  public static PokemonGenerator getInstance(){
    if (instance == null){
      instance = new PokemonGenerator();
    }
    return instance;
  }

  public Pokemon generateRandomPokemon(int level){
	  Object[] keys = pokemon.keySet().toArray();
	  Object name = keys[GenerateRandom.genIntBtw(1, keys.length) - 1];
    // Generate Pokemon based on its level.
    int i = 2;
    Pokemon p = getPokemon((String) name);
    while (i <= level){
      p = addRandomBuff(p);
      i++;
    }
    return p;
  }

  public Pokemon getPokemon(String name){
	  String type = pokemon.get(name);
	  int maxHp = GenerateRandom.genIntBtw(22, 25);
	  
	  if (type.equals("Water")){
		  return new Water(name, maxHp, maxHp);
	  }else if (type.equals("Fire")){
		  return new Fire(name, maxHp, maxHp);
	  }else if (type.equals("Grass")){
		  return new Grass(name, maxHp, maxHp);
	  }else{
		  ;
	  }
	return null;
  }

  public Pokemon addRandomBuff(Pokemon p){
	  int buffType = GenerateRandom.genIntBtw(0, 1);
	  switch(buffType){
		  case 0:
		  	// +ATK
			  return new AttackUp(p);
		  case 1:
			  // +HP
			  return new HpUp(p);
	  }
	  return null;

  }

  public Pokemon addRandomDebuff(Pokemon p){
    int buffType = GenerateRandom.genIntBtw(0, 1);
	  switch(buffType){
		case 0:
		  // -ATK
			return new AttackDown(p);
		case 1:
			// -HP
			return new HpDown(p);
	  }
	return null;
  }
}