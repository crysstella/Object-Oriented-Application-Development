import java.util.*;
import java.io.*;

public class EnemyGenerator{
  private ArrayList<Enemy> enemyList;

  /**
   * A constructor reads in a file of template enemies 'name,maxHp'
   * and stores them in the ArrayList.
   */
  public EnemyGenerator(){
    try{
      String fileName = "enemyList.txt";
      File inputFile = new File(fileName);
      Scanner read = new Scanner(inputFile);
      String name;
      int maxHp;
      enemyList = new ArrayList<Enemy>();
      
      while (read.hasNext()){
        String[] token = read.nextLine().split(",");
        name = token[0];
        maxHp = Integer.parseInt(token[1]);
        
        enemyList.add(new Enemy(name, maxHp));
      }
      read.close();
    }catch (FileNotFoundException e){
      System.out.println("FNF");
    }
  }

  /**
   * Chooes a random enemy from the ArrayList
   * and creates a copy of it to return. 
   *
   * @return a copy of the random enemy in the ArrayList.
  */
  public Enemy generateEnemy(){
    int size = enemyList.size() - 1;
    int rand = (int) (Math.random() * size);
    Enemy e = enemyList.get(rand).clone();
    
    return e;
  }
}