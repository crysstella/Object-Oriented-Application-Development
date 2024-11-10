/*
Matthew Kriesel
Stellar Ngyuen
This program take a zipcode (string input) from the console and converts it into a USPS bar code
*/
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    System.out.print("Enter a zip code: ");
    String zip = getZip();
    printBarCode(zip);
  }

  /**Get the user's input
    *Return the zipcode as a string with 5-digit value
  */
  public static String getZip(){
    int zip;
    String zipS = "";

    Scanner in = new Scanner(System.in);
    boolean valid = false;
    while (!valid){
      if (in.hasNextInt()){
          zip = in.nextInt();
          zipS = ""+zip;
          if (zipS.length() == 5){
            break;
          } else {
            System.out.print("Input not in range 10000 - 99999. Enter again: ");
          }
      }else{
        in.next();
        System.out.print("Zipcode needs to be a 5-digit value. Enter again: ");
      }
    }
    return zipS;
  }

  /** Print Digit from 0-9
  */
  public static void printDigit(char d){
    switch(d){
      case '1': 
        System.out.print("...||");
        break;
      case '2': 
        System.out.print("..|.|");
        break;
      case '3': 
        System.out.print("..||.");
        break;
      case '4': 
        System.out.print(".|..|");
        break;
      case '5': 
        System.out.print(".|.|.");
        break;
      case '6': 
        System.out.print(".||..");
        break;
      case '7': 
        System.out.print("|...|");
        break;    
      case '8': 
        System.out.print("|..|.");
        break;   
      case '9':
        System.out.print("|.|..");
        break;
      case '0':
        System.out.print("||...");
        break;
      default:
        break;
    }
  }

  /**Convert each character in a string to an integer
    *Sum of all the digit
    *Sum/10 * 10 : to get the integer part and then multiplied by ten to get tens place integer
    *Plus 10 to get round up number
  */
  public static char getCheckDigit(String zip){
    int checkDigit;
    int sum = 0;

    for (int i=0; i < zip.length(); i++){
      int num = Integer.parseInt(String.valueOf(zip.charAt(i)));
      sum += num;
    }
    
    int roundUp = (sum/10)*10 + 10; 
    checkDigit = roundUp - sum;

    return (char)(checkDigit+48);
  }

  /*
    Print the barcode to screen.
  */
  public static void printBarCode(String zip){
    System.out.print("|");
    for (int i = 0; i < zip.length(); i++){
      printDigit(zip.charAt(i));
    }
    printDigit(getCheckDigit(zip));
    System.out.print("|");

  }
}