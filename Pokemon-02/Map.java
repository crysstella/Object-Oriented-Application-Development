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
	private static Map instance = null;
	
  /**
   * Constructor
   * Creating new character map and new revealed array.
   */
	private Map() {
    	map = new char[mapSide][mapSide];
	  	revealed = new boolean[mapSide][mapSide];
	}

  /**
   * Get map instance.
   *
   * @return map instance.
   */
	public static Map getInstance(){
		if (instance == null){
			instance = new Map();
		}
		return instance;
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
	public char getCharAtLoc(Point p) {
		// out of range
		if (p.getX() < 0 || p.getX() > mapSide-1 || p.getY() < 0 || p.getY() > mapSide-1) {
			return 'x';
		}
		return map[p.getX()][p.getY()];

	}

  /**
   * Display a map with characters in previous location.
   * Display current location by *.
   * 
   * @param charaPoint a point of a character (current location) .
   * @return a string map .
   */
	public String mapToString(Point p) {
		String str_map = "";
    	str_map += "Map:\n";
		for (int i = 0; i < mapSide; i++) {
			for (int j = 0; j < mapSide; j++) {
				if (p.getX() == i && p.getY() == j) {
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
