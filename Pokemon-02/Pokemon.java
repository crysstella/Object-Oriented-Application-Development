 public abstract class Pokemon extends Entity {
  public static final double[][] battleTable = { { 1, .5, 2 }, { 2, 1, .5 }, { .5, 2, 1 } };

  public Pokemon(String n, int h, int m) {
    super(n, h, m);
  }

  public String getAttackTypeMenu() {
    return "1. Basic Attack\n2. Special Attack";
  }

  public int getNumAttackTypeMenuItems() {
    return 2;
  }

  public String getAttackMenu(int atkType) {
    if (atkType == 1){
      return "1. Slam\n2. Tackle\n3. Punch";
    }
    return "";
  }

  public int getNumAttackMenuItems(int atkType) {
    return 3;
  }

  public String getAttackString(int atkType, int move) {
    if (atkType == 1) {
      switch (move) {
        case 1:
          return "SLAMMED";
        case 2:
          return "TACKLED";
        default:
          return "PUNCHED";
      }
    }
    return "";
  }

  public int getAttackDamage(int atkType, int move) {
    if (atkType == 1) {
      switch (move) {
        case 1:
          return GenerateRandom.genIntBtw(0, 5);
        case 2:
          return GenerateRandom.genIntBtw(2, 3);
        default:
          return GenerateRandom.genIntBtw(1, 4);
      }
    }
    return 0;
  }

  public double getAttackMultiplier(Pokemon p, int atkType) {
    return 1.0;
  }

  public int getAttackBonus(int atkType) {
      return 0;
  }

  public String attack(Pokemon p, int atkType, int move) {
      /*double multiplier = getAttackMultiplier(this, atkType);
      System.out.println("multiplier = " + multiplier);
      int d = (int)(getAttackDamage(atkType, move)*getAttackMultiplier(this, atkType)) + this.getAttackBonus(atkType);
      p.takeDamage(d);
      return  p.getName() + " is " + this.getAttackString(atkType, move) + " by " + this.getName() + " and takes " + d + " damage.";*/
      //return this.getName() + " attacks " + p.getName();
      System.out.println("getAttackBonus(" + atkType +") = " + this.getAttackBonus(atkType));
      return "";
  }

  public int getType() {
    if (this instanceof Fire) {
      return 0;
    } else if (this instanceof Water) {
      return 1;
    } else {
      return 2;
    }
  }

}