import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		int score = 0;

		while(true)
		{
			int numberToGuess = rnd.nextInt(100)+1;
			int attempts = 10;
			boolean guessedCorrectlty = false;
			System.out.println("\nWelcome to Guess the Number Game!");
			System.out.println("\nI am thinking of a number between 1 and 100(1-100).\nGuess what is is...");

			while(attempts>0 && !guessedCorrectlty)
			{
				System.out.println("\nYou have "+attempts+" attempts left.\nEnter your guess : ");
				int guess = sc.nextInt();
				attempts--;
				if(guess == numberToGuess)
				{
					System.out.println("\nCongratulations!You have guessed the number in "+(10-attempts)+" attempts");
					score++;
					guessedCorrectlty=true;
				}
				else if(guess<numberToGuess)
				{
					System.out.println("\nToo low!Guess higher");
				}
				else
				{
					System.out.println("\nToo high!Guess lower");
				}
			}
			if(!guessedCorrectlty)
			{
				System.out.println("\nSorry! you ran out of attempts.The number was"+numberToGuess+".");
			}
			System.out.println("\nYour current score is "+score+". \n\nPlay again?(yes/no):");
			String playagain = sc.next();
			if(!playagain.equalsIgnoreCase("yes"))
			{
				break;
			}
		}
		System.out.println("\nThanks for playing! Your final score is "+score);
	}
}