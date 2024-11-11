/**
 * Shows visited position and prints out as string.
 *
 * @author Keyi Wang
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
	private final int mapSide = 5;
	private char[][] map;
	private boolean[][] revealed;
	

  /**
   * Constructor
   * Creating new character map and new revealed array.
   */
	public Map() {
    map = new char[mapSide][mapSide];
	  revealed = new boolean[mapSide][mapSide];
	}
  
	/**
   * Loading map from a file.
	 * @param mapNum number of map loaded.
   * @throws file not found catch.
	 */

	public void loadMap(int mapNum) {
    try{
      String filename = "Area" + mapNum + ".txt";
      File inputFile = new File( filename );
      Scanner fp = new Scanner(inputFile);

      for (int i = 0; i < mapSide; i++) {
        String[] sign = fp.nextLine().split(" ");
        for (int j = 0; j < mapSide; j++) {
          map[i][j] = sign[j].charAt(0);
        }
      }
      fp.close();
      revealed = new boolean[mapSide][mapSide];
    }catch (FileNotFoundException e){
      System.out.println("FNF!");
    }
	}

  /**
   * Retrieve a character at a point.
   * If a point is not in range, return 'x'.
   *
   * @param point a point that has a character.
   * @return a character at a point.
   */
	public char getCharAtLoc(Point point) {
		// out of range
		if (point.getX() < 0 || point.getX() > mapSide-1 || point.getY() < 0 || point.getY() > mapSide-1) {
			return 'x';
		}
		return map[point.getX()][point.getY()];

	}

  /**
   * Display a map with characters in previous location.
   * Display current location by *.
   * 
   * @param charaPoint a point of a character (current location) .
   * @return a string map .
   */
	public String mapToString(Point charaPoint) {
		String str_map = "";
    	str_map += "Map:\n";
		for (int i = 0; i < mapSide; i++) {
			for (int j = 0; j < mapSide; j++) {
				if (charaPoint.getX() == i && charaPoint.getY() == j) {
					str_map += "* ";
				} else if (revealed[i][j]) {
					str_map += map[i][j] + " ";
				} else {
					str_map += "x ";
				}
			}
			str_map += "\n";
		}
		return str_map;
	}

  /**
   * Finding a location with 's'.
   * @return a point with 's' character or null if not have any 's'.
   */
	public Point findStart() {
		for (int i = 0; i < mapSide; i++) {
			for (int j = 0; j < mapSide; j++) {
				if (map[i][j] == 's') {
					return new Point(i, j);
				}
			}
		}
    	return null;
	}

  /**
   * Mark a location true to reveal a character.
   * @param p a location.
   */
	public void reveal(Point p) {
		revealed[p.getX()][p.getY()] = true;
	}

  /**
   * Remove a character at a location.
   * @param p a location point.
   */
	public void removeCharAtLoc(Point p) {
    	map[p.getX()][p.getY()] = 'n';
	}
}
