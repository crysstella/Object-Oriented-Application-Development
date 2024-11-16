import java.io.*;
import java.util.*;

/**
 * Matthew Kriesel
 * Stellar Nguyen
 * 11/03/2021
 * Keeps track of the frequency of each of the words in a text file by using a TreeMap.
 */


class Main {
  public static void main(String[] args) {
    TreeMap<String, Integer> words = new TreeMap<String, Integer>();
    String fileName = "words.txt";
    Integer input = 0;

    words = readFile(fileName);

    while (input != 3) {
      input = menu();
      if (input == 1) {
        search(words);
      } else if (input == 2) {
        display(words);
      }else{
        System.out.println("Program Stop.");
      }
    }
  }

  /**
   * Reads words in words.txt and adds them to the tree map with its frequency.
   * 
   * @param fileName name of file read.
   * @return the tree map of words with their frequencies.
   */
  public static TreeMap<String, Integer> readFile(String fileName) {
    TreeMap<String, Integer> words = new TreeMap<String, Integer>();
    try {
      File inputFile = new File(fileName);
      Scanner read = new Scanner(inputFile);
      Integer i = 1;
      String word = "";

      while (read.hasNext()) {
        word = read.nextLine();
        if (words.containsKey(word)) {
          i = words.get(word) + 1;
        }
        words.put(word, i);
      }
      read.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found!");
    }

    return words;
  }

  /**
   * Prompt the user to enter a String and display the word with its frequency: 
   * "word => frequency". If it is not in the map, its frequency is 0.
   *
   * @param words the tree map of words with theire frequencies.
   */
  public static void search(TreeMap<String, Integer> words) {
    String word = "";
    System.out.print("Enter word: ");
    word = CheckInput.getString();

    if (words.containsKey(word)) {
      System.out.println(word + " => " + words.get(word));
    } else {
      System.out.println(word + " => " + 0);
    }
  }

  /**
   * Display each of the words with their frequencies: "word => frequency".
   * 
   * @param words the tree map of words with theire frequencies.
   */
  public static void display(TreeMap<String, Integer> words) {
    Set<String> word = words.keySet();
    for (String s : word) {
      System.out.println(s + " => " + words.get(s));
    }
  }

  /**
   * Display the menu to prompt the user to enter a menu option and
   * get user's option.
   *
   * @return the user's valid option.
   */
  public static int menu() {
    System.out.println("1. Search\n" + "2. Display\n" + "3. Quit");
    Integer input = 0;
    input = CheckInput.getIntRange(1, 3);

    return input;
  }
}