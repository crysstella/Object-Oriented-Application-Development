public class AttackUp extends PokemonDecorator{

  public AttackUp(Pokemon p){
    super(p, " +ATK", 0); 
  }

  @Override
  public int getAttackBonus(int atkType){
	  /*if (atkType == 0){// fire
		  return GenerateRandom.genIntBtw(3, 4);
	  } else if (atkType == 1){ // water
		return GenerateRandom.genIntBtw(2, 3);
	  } else if (atkType == 2){ // grass
		  return GenerateRandom.genIntBtw(1, 2);
	  }*/
    return GenerateRandom.genIntBtw(1, 2);
  }
}