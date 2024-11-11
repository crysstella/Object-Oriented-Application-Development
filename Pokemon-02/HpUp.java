public class HpUp extends PokemonDecorator{
  public HpUp(Pokemon p){
    super(p, " +HP", GenerateRandom.genIntBtw(1, 2)); // 1-2
  }
}