public class EatingState implements PuppyState{
  /**
   * Representation of play.
   * 
   * @param p a puppy.
   * @return representation of play.
   */
  @Override
  public String play(Puppy p){
    p.setState( new PlayState() );
    int play = p.incPlay();
    if (play == 1){
      System.out.println("The puppy looks up from its food and chases the ball you threw.");
    }else if (play < 3){
      System.out.println("You throw the ball again and the puppy excitedly chases it.");
    }
    
    if (play == 3){
      p.setState( new AsleepState() );
      p.reset();
      return "The puppy played so much it fell asleep!";
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