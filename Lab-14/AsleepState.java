public class AsleepState implements PuppyState{
  /**
   * Representation of play.
   * 
   * @param p a puppy.
   * @return representation of play.
   */
  @Override
  public String play(Puppy p){
    return "The puppy is asleep. It doesn't want to play right now.";
  }

  /**
   * Representation of giving food.
   *
   * @param p a puppy.
   * @return representation of giving food.
   */
  @Override
  public String feed(Puppy p){
    p.setState( new EatingState() );
    int feed = p.incFeeds();
    return "The puppy wakes up and comes running to eat.";
  }

}