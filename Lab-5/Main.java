/** Stellar Nguyen
  * Matthew Kriesel
  * 09/21/2021
  * Creates a rectangle with width and height in the 20x20 grid. Then allows users to move 
  * the rectangle up or down, left or right.
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int width=0;
    int height=0;
    char [][] grid = new char [20][20];

    boolean validWidth = false;
    boolean validHeight = false;
    while ((!validWidth) || (!validHeight)){
      if (validWidth == false){
        System.out.print("Enter rectangle width (1-5)? ");
        if (in.hasNextInt()){
          width = in.nextInt();
          if ((width > 0) && (width < 6)){
            validWidth = true;
          }else{
            System.out.println("Width must be between 1 and 5!");
          }
        }else{
          in.next();
          System.out.println("Invalid input.");
        }
      }else if (validHeight == false){
        System.out.print("Enter rectangle height(1-5): ");
          if (in.hasNextInt()){
            height = in.nextInt();
            if ((height > 0) && (height < 6)){
              validHeight = true;
            }else{
              System.out.println("Height must be between 1 and 5!");
            }
          }else{
            in.next();
            System.out.println("Invalid input.");
          }
      }
    }
    
    Rect rect = new Rect(width, height);
    resetGrid(grid);
    placeRect(grid, rect);
    displayGrid(grid);

    int choice = 0;
    int row = grid.length;
    int col = grid[0].length;

    while (choice != 5){
      menu();
      boolean valid = false;
      while (!valid){
        if (in.hasNextInt()){
          choice = in.nextInt();
          if ((choice > 0) && (choice < 6)){
            valid = true;
          }else{
            System.out.println("Your option does not exist!");
          }
        }else{
          in.next();
          System.out.println("Invalid input.");
        }
      }

      int x = rect.getX();
      int y = rect.getY();
      resetGrid(grid);

      switch(choice){
        case 1:
          if (y == 0){
            System.out.println("You cannot go that way.");
          }else{
            rect.translate(0, -1);
            placeRect(grid, rect);
            displayGrid(grid);
          }
          break;
        case 2:
          if ((y+height) == row){
            System.out.println("You cannot go that way.");
          }else{
            rect.translate(0, 1);
            placeRect(grid, rect);
            displayGrid(grid);
          } 
          break;
        case 3:
          if (x == 0){
            System.out.println("You cannot go that way.");
          }else{
            rect.translate(-1, 0);
            placeRect(grid, rect);
            displayGrid(grid);
          }
          break;
        case 4:
          if ((x+width) == col){
            System.out.println("You cannot go that way.");
          }else{
            rect.translate(1, 0);
            placeRect(grid, rect);
            displayGrid(grid);
          }
          break;
        default:
          break;
      }
    }

  }

/** Displays the grid
 * @param 2D grid the grid
*/
  public static void displayGrid(char [][] grid){
    int rows = grid.length;
    int cols = grid[0].length;

    for (int i=0; i < rows; i++){
      for (int j=0; j < cols; j++){
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
  }

/** Adds the rectangle to the grid according to (x,y) location
 * @param 2D grid the grid
 * @param rect the rectangle is placed in the grid
*/
  public static void placeRect(char [][] grid, Rect rect){
    int y = rect.getY();
    int x = rect.getX();
    int height = rect.getHeight();
    int width = rect.getWidth();

    for (int i=y; i < height + y; i++){
      for (int j=x; j < width + x; j++){
        grid[i][j] = '*';
      }
    }
  }

/**Fills the grid with "."
 * @param 2D grid the grid
*/
  public static void resetGrid(char [][] grid){
    int rows = grid.length;
    int cols = grid[0].length;

    for (int i=0; i < rows; i++){
      for (int j=0; j < cols; j++){
        grid[i][j] = '.';
      }
    }
  }

/**Displays options for users
*/
  public static void menu(){
    System.out.println("Enter direction:");
    System.out.println("1. Up");
    System.out.println("2. Down");
    System.out.println("3. Left");
    System.out.println("4. Right");
    System.out.println("5. Quit");
  }
}