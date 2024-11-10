/**
 * Matthew Kriesel
 * Stellar Nguyen
 * 10/27/2021
 * Creates a linked list and adds words from words.txt into it in sorted order using a listIterator.
 */
import java.io.*;
import java.util.Scanner;
import java.util.ListIterator;
import java.util.LinkedList;

class Main {
  public static void main(String[] args){
    try{
      LinkedList<String> list = new LinkedList<String>();

      list = readFile(list);
      printList(list);
    } catch (FileNotFoundException e){
      System.out.println("File not Found");
    }
  }

  /**
   * Reads words in words.txt and adds them to the list in order.
   * @param list the list contains words.
   * @return the sorted list.
   */
  public static LinkedList<String> readFile(LinkedList<String> list) throws FileNotFoundException {
    String fileName = "words.txt";
    File inputFile = new File(fileName);
    Scanner read = new Scanner(inputFile);
    ListIterator<String> iter = list.listIterator();
    String word = "";

   
    while (read.hasNext()) {
      word = read.nextLine();
      moveIter(iter, word);
      iter.add(word);
    }
    read.close();
    return list;
  }

  /**
   * Displays the list after sorting.
   * @param list the list contains words.
   */
  public static void printList(LinkedList<String> list) {
    ListIterator<String> iter = list.listIterator();
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
  }

  /**
   * Moves the iterator back and forth to the correct position.
   * @param list the list contains words.
   * @param word a word being added to compare to the word at the iterator's position.
   */
  public static void moveIter(ListIterator<String> iter, String word) {
    String current = "";

    while (iter.hasNext()){
      current = iter.next();
      if (current.compareToIgnoreCase(word) < 0){
        //do nothing
      }else if (current.compareToIgnoreCase(word) > 0){
        current = iter.previous();
        break;
      }else{
        //do nothing
      }
    }

    while (iter.hasPrevious()){
      current = iter.previous();
      if (current.compareToIgnoreCase(word) < 0){
        current = iter.next();
        break;
      }else if (current.compareToIgnoreCase(word) > 0){
        //do nothing
      }else{
        //do nothing
      }
    }
  }
}