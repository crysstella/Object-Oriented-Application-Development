public class PlayState implements PuppyState{
  /**
   * Representation of play.
   * 
   * @param p a puppy.
   * @return representation of play.
   */
  @Override
  public String play(Puppy p){
    int play = p.incPlay();
    System.out.println("You throw the ball again and the puppy excitedly chases it.");
    if (play == 3){
      p.setState(new AsleepState());
      p.reset();
      return "The puppy played so much it fell asleep.";
    }
    return "";
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
    System.out.println("The puppy continues to eat as you add another scoop of kibble to its bowl.");
    int feed = p.incFeeds();
    if (feed == 3){
      p.setState(new AsleepState());
      p.reset();
      return "The puppy ate so much it fell asleep!";
    }
    return "";
  }
}