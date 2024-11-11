public class Grass extends Pokemon{
  public Grass(String n, int h, int m){
    super(n, h, m);
  }

   @Override
  public String getAttackMenu(int atkType){
    if (atkType == 2){
      return "1. Vine Whip\n2. Razor Leaf\n3. Solar Beam";
    }
	  return super.getAttackMenu(atkType);
  }

  @Override
  public int getNumAttackMenuItems(int atkType){
    return 3;
  }

  @Override
  public String getAttackString(int atkType, int move){
    if (atkType == 2){
      switch (move){
        case 1:
          return "WHIPPED";
        case 2:
          return "SLICED with GRASS";
        default:
          return "BEAMED";
      }
    }
    return super.getAttackString(atkType, move);
  }

  @Override
  public int getAttackDamage(int atkType, int move){
    if (atkType == 2){
      switch(move){
        case 1:
          return GenerateRandom.genIntBtw(0, 4);
        case 2:
          return GenerateRandom.genIntBtw(1, 5);
        default:
          return GenerateRandom.genIntBtw(1, 4);
      }
    }
    return super.getAttackDamage(atkType, move);
  }

  @Override
  public double getAttackMultiplier(Pokemon p, int atkType){
    if (atkType == 2){
      return battleTable[2][getType()];
    }
    return super.getAttackMultiplier(p, atkType);
  }
}