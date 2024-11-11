/** Stellar Nguyen
  * Matthew Kriesel
  * 09/13/2021
  * Displays statistical information about US states and territories and their populations.
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.io.File;

class Main {
  public static void main(String[] args) {
    ArrayList <String> state = new ArrayList <String> (100);
    ArrayList <Integer> population = new ArrayList <Integer> (100);
    Scanner inp = new Scanner(System.in);
    int option = 0;

    readFile(state, population);

    while (option != 5){
      menu();
      boolean valid=false;
      
      while (!valid){
        if (inp.hasNextInt()){
          option = inp.nextInt();
          if ((option > 0) && (option < 6)){
            valid = true;
          }else{
            System.out.print("Option is not available. Enter again: ");
          }
        }else{
          inp.next();
          System.out.print("Option should be an integer from 1 to 5. Enter again: ");
        }
      }

      switch(option){
        case 1:
          sortStates(state, population);
          displayStates(state, population);
          break;
        case 2:
          sortPopulation(state, population);
          displayStates(state, population);
          break;
        case 3:
          System.out.printf("US Population = %,d \n", totalSum(population));
          break;
        case 4: 
          populationGreater(state, population);
          break;
        default:
          break;
      }
    }
  }

/* Reads datas of populations which belongs to specific states from "StatePops.txt"
 * Creates a new tokens to split information by ","
 * Add tokens to state list and population list
 * @param state the list of states
 * @param pop   the list of populations
*/
  public static void readFile(ArrayList <String> state, ArrayList <Integer> pop){
    try{
      File stats = new File ("StatePops.txt");
      Scanner reader = new Scanner(stats);

      while (reader.hasNext()){
        String line = reader.nextLine();
        String [] tokens = line.split(",");
        state.add(tokens[0]);
        pop.add(Integer.parseInt(tokens[1]));
      }
      reader.close();

    } catch (FileNotFoundException e){
      System.out.println("File was not found.");
    } catch (ArrayIndexOutOfBoundsException e){
      System.out.println("Invalid index.");
    }
  }


/**Sorts the state list and population list alphabetically by state name
 * @param state the list of states
 * @param pop   the list of populations
*/
  public static void sortStates(ArrayList <String> state, ArrayList <Integer> pop){
    boolean swapped = false;
    do{
      swapped = false;
      for (int i = 0; i < state.size()-1; i++){
        if (state.get(i).compareTo(state.get(i+1)) > 0){
          String swapS = state.get(i);
          state.set(i, state.get(i+1));
          state.set(i+1, swapS);

          int swapP = pop.get(i);
          pop.set(i, pop.get(i+1));
          pop.set(i+1, swapP);

          swapped = true;
        }
      }
    } while (swapped);
  }

/* Sorts the lists by population (from low to high)
 * @param state the list of states
 * @param pop   the list of populations
*/
  public static void sortPopulation(ArrayList <String> state, ArrayList <Integer> pop){
    boolean swapped = false;
    do{
      swapped = false;
      for (int i = 0; i < pop.size()-1; i++){
        if (pop.get(i) > pop.get(i+1)){
          int swapP = pop.get(i);
          pop.set(i, pop.get(i+1));
          pop.set(i+1, swapP);

          String swapS = state.get(i);
          state.set(i, state.get(i+1));
          state.set(i+1, swapS);

          swapped = true;
        }
      }
    } while (swapped);
  }

/* Display each state and its population
 * @param state the list of states
 * @param pop   the list of populations 
*/
  public static void displayStates(ArrayList <String> state, ArrayList <Integer> pop){
    for (int i=0; i < state.size(); i++){
      System.out.printf("%s ", state.get(i));
      System.out.printf("%,d \n",pop.get(i));
    }
  }

/* Calculates the total population
 * @param pop   the list of populations 
 * @return      total population
*/
  public static int totalSum(ArrayList <Integer> pop){
    int sum=0;
    for (int i=0; i < pop.size(); i++){
      sum += pop.get(i);
    }

    return sum;
  }

/* Prompts the user to enter a population
 * Displays all states and their populations that have a larger population than 
 * what the user entered
 * Displays the data from low to high
 * @param state the list of states
 * @param pop   the list of populations 
*/
  public static void populationGreater (ArrayList <String> state, ArrayList <Integer> pop){
    System.out.print("Enter Population: ");
    Scanner inp = new Scanner(System.in);
    int num=0;
    boolean valid = false;

    while (!valid){
      if (inp.hasNextInt()){
        num = inp.nextInt();
        valid = true;
      }else{
        inp.next();
        System.out.print("Population should be an integer: ");
      }
    }

    sortPopulation(state, pop);
    for (int i=0; i < pop.size(); i++){
      if (pop.get(i) > num){
        System.out.printf("%s %,d \n", state.get(i), pop.get(i));
      }
    }
  }

  /* Displays the menu options for users
  */
  public static void menu(){
    System.out.println("State Stats");
    System.out.println("1. Display Sorted States");
    System.out.println("2. Display Sorted Populations");
    System.out.println("3. Display Total US Population");
    System.out.println("4. Display States with Population Greater Than");
    System.out.println("5. Quit");
  }
}