public class Puppy {
  private PuppyState state;
  private int numFeeds;
  private int numPlays;

  /**
   * Construct a new puppy asleep.
   */
  public Puppy(){
    state = new AsleepState();
  }

  /**
   * Set a state of a puppy.
   *
   * @param s a current state.
   */
  public void setState(PuppyState s){
    state = s;
  }

  /**
   * Representation of playing/ throwing ball.
   * 
   * @param p a puppy.
   * @return representation of playing/ throwing ball.
   */
  public String throwBall(){
    return state.play( this );
    
  }

  /**
   * Representation of giving food.
   *
   * @param p a puppy.
   * @return representation of giving food.
   */
  public String giveFood(){
    return state.feed( this );
    
  }

  /**
   * Increment the time of feeding
   * and retrieve numFeeds value.
   *
   * @return numFeeds value.
   */
  public int incFeeds(){
    numFeeds++;
    return numFeeds;
  }

  /**
   * Increment the time of playing
   * and retrieve numPlays value.
   *
   * @return numPlays value.
   */
  public int incPlay(){
    numPlays++;
    return numPlays;
  }

  /**
   * Set the numFeeds and numPlays to 0.
   */
  public void reset(){
    numFeeds = 0;
    numPlays = 0;
  }

}