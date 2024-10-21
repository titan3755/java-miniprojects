package number_guess;

import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Scanner extScnr = new Scanner(System.in);
		String usrRes;
		String outcome;
		printIntro();
		while(true) {
			outcome = game();
			if (outcome.contains("Number:")) {
				System.out.println("\nGame over, you lost!");
				System.out.println(outcome);
			} else {
				System.out.println("\nGame over, you won!");
				System.out.println(outcome);
			}
			System.out.print("Do you want to play again? (y/n):");
			usrRes = extScnr.nextLine();
			if (usrRes.toLowerCase() == "y" || usrRes.toLowerCase() == "yes") {
				continue;
			} else {
				break;
			}
		}
		extScnr.close();
	}
	
	static void printIntro() {
		System.out.println("Welcome to Number Guessing Game!");
		System.out.println("The computer will select a random number between 1 and 20");
		System.out.println("Try your best to guess the number");
		System.out.println("You will get 5 tries to do so");
		System.out.println("Every failed attempt will result in a reduction of score");
		System.out.println("Good luck!");
		System.out.print("\n\n");
	}
	
	static String game() {
		Scanner scnr = new Scanner(System.in);
		Random rand = new Random();
		int score = 10;
		int randomNum = rand.nextInt((20 - 1) + 1) + 1;
		String usrResp;
		while(score > 0) {
			System.out.print("Guess the number: ");
			usrResp = scnr.nextLine();
			try {
				if (Integer.parseInt(usrResp) == randomNum) {
					System.out.println("You guessed correctly! " + randomNum + " was indeed the selected number!");
					scnr.reset();
					scnr.close();
					return "Score: " + score;
				} else {
					System.out.println("Incorrect! Try again...");
					score -= 2;
				}
			} catch (Exception e) {
				System.out.println("\nAn error occured! Err: [" + e.getMessage() + "]\n");
			}
		}
		scnr.reset();
		scnr.close();
		return "Number: " + randomNum;
	}
}
