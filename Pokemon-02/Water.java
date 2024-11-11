public class Water extends Pokemon{
  public Water(String n, int h, int m){
    super(n, h, m);
  }

  @Override
  public String getAttackMenu(int atkType){
	  if (atkType == 2){
      return "1. Water Gun\n2. Bubble Beam\n3. Waterfall";
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
          return "SPRAYED";
        case 2:
          return "WARPPED with WATER";
        default:
          return "SMASHED by WATER FALL";
      }
    }
	  return super.getAttackString(atkType, move);
  }

  @Override
  public int getAttackDamage(int atkType, int move){
	  if (atkType == 2){
      switch(move){
        case 1:
          return GenerateRandom.genIntBtw(1, 5);
        case 2:
          return GenerateRandom.genIntBtw(1, 2);
        default:
          return GenerateRandom.genIntBtw(1, 4);
      }
    }
	  return super.getAttackDamage(atkType, move);
  }

  @Override
  public double getAttackMultiplier(Pokemon p, int atkType){
	  if (atkType == 2){
      return battleTable[1][getType()];
    }
	  return super.getAttackMultiplier(p, atkType);
  }
}