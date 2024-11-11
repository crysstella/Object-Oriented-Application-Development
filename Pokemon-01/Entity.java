/**
 * Abstract class that is extended by all the entities used to 
 * initiallize the attributes of an entity.
 *
 * @author Keyi Wang
 */
public abstract class Entity {
  private String name;
  private int hp;
  private int maxHp;


  /**
   * Constructor
   * Creating initial name, hp, and maxHp.
   *
   * @param n name.
   * @param mHp max Hp.
   */
	public Entity(String n, int mHp) {
		name = n;
		maxHp = mHp;
		hp = mHp;
	}

  /**
   * Retrieve hp value.
   * @return hp value.
   */
	public int getHp() {
		return hp;
	}

  /**
   * Retrieve max HP value.
   * @return max HP value.
   */
	public int getMaxHp() {
		return maxHp;
	}

  /**
   * Subtract the current HP of the object by damage taken.
   * If HP is less than 0, HP equals 0.
   *
   * @param d damage taken.
   */
	public void takeDamage(int d) {
		hp = hp-d > 0 ? hp-d : 0;
	}

  /**
   * Healing object to max HP.
   */
	public void heal() {
		// +5
		//hp = hp+5 > getMaxHp() ? getMaxHp() : hp+5;
		hp = maxHp;
	}

  /**
   * Retrieve object's name.
   * @return object's name.
   */
	public String getName() {
		return name;
	}

  /**
   * Display the object's name and hp/maxHp.
   * @return the object's name and hp/maxHp.
   */
	@Override
	public String toString() {
		return getName() + " HP: " + getHp() + "/" + getMaxHp() + "\n";
	}

}