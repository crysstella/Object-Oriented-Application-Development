/*
 * Name: Stellar Nguyen, Matthew Kriese
 * Date: 08/23/2021	
 * Desc: Guessing the number that is generated and count how many times to get the right answer. 
 */

public class Main {

	public static void main(String[] args) {
		int rand = (int)(Math.random()*100) +1; //1-100
		int guessNum = -1;
		int count = 0;
		
		System.out.print("I'm thinking of a number. Guess a value (1-100): ");
		while (guessNum != rand) {
			guessNum = CheckInput.getIntRange(1, 100);
			count++;
			
			if (guessNum < rand) {
				System.out.print("Too Low.    Guess again: ");
			}else if (guessNum > rand) {
				System.out.print("Too High.   Guess again: ");
		  }
		}

		System.out.println("Correct!   You got it in " + count + " tries");
		
		                            
		
	}

}
