/**Matthew Kriesel
  *Stellar Nguyen
  *This program creates minesweeper board
*/

import java.lang.Math;

class Main {
  final static int MINE = 9;

  public static void main(String[] args) {
    int row;
    int col;
    int mines;

    
    System.out.println("Minesweeper Maker");
    System.out.print("Enter number of Rows (5-10) :");
    row = CheckInput.getIntRange();

    System.out.print("Enter number or Columns (5-10) :");
    col = CheckInput.getIntRange();

    System.out.print("Enter number of Mines (5-10) :");
    mines = CheckInput.getIntRange();
    
    int [][] grid = new int [row][col];

    placeMines(grid, mines);
    fillGrid(grid);
    displayGrid(grid);
  }

/**Placing mines at random rows and random columns
  *based on the number of mines that user inputed
  *@param grid minesweeper grid
  *@param mines the number of mines to be added
*/
  public static void placeMines(int [][] grid, int mines){
    int row = grid.length;
    int col = grid[0].length;
    int rowRand;
    int colRand;

    while (mines > 0){
      rowRand = (int)(Math.random()*row);     //0 to row-1
      colRand = (int)(Math.random()*col);     //0 to col-1
      if ((grid[rowRand][colRand]) != MINE){
        grid[rowRand][colRand] = MINE;
        mines--;
      }  
    }
  }

/**fills each spot in the grid with counter of mines 
  *in the surrounding eight spaces
  @param grid minesweeper grid
*/
  public static  void fillGrid(int [][] grid){
    int row = grid.length;
    int col = grid[0].length;
    
    //Create a new array same as grid with 2 more rows and      columns
    int [][] temp = new int [row+2][col+2];

    for (int i=1; i < row+1; i++){
      for (int j=1; j < col+1; j++){
        temp[i][j] = grid[i-1][j-1];
      }
    }

    for (int i=1; i < row+1; i++){
      for (int j=1; j < col+1; j++){
        int count = 0;
        if (temp[i][j] != MINE){
          for (int k=i-1; k <= i+1; k++){
              for (int l=j-1; l <= j+1; l++){
                if (temp[k][l] == MINE){
                  count++;
                }
              }
          }
          temp[i][j] = count;
          grid[i-1][j-1] = count;
        }
      }
    }
  }

/**Print out the grid to screen
  *@param grid minesweeper grid
*/
  public static void displayGrid(int [][] grid){
    int row = grid.length;
    int col = grid[0].length;

    for (int i=0; i < row; i++ ){
      for (int j = 0; j < col; j++){
        System.out.print(grid[i][j] + " ");
       }
      System.out.println();
    }
  }
}