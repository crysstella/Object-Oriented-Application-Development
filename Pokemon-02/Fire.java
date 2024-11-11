public class Fire extends Pokemon{
  public Fire(String n, int h, int m){
    super(n, h, m);
  }

  @Override
  public String getAttackMenu(int atkType){
    if (atkType == 2){
      return "1. Ember\n2. Fire Blast\n3. Fire Punch";
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
          return "EMBERRED";
        case 2:
          return "BLASTED with FIRE";
        default:
          return "PUNCHED by FIRE";
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
      return battleTable[0][getType()];
    }
    return super.getAttackMultiplier(p, atkType);
  }
}