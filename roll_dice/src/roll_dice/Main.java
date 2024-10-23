package roll_dice;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Dice dice = new Dice();
		String input;
		boolean rollAgain = false;
		printIntro();
		while (true) {
			if (!rollAgain) {
				System.out.print("Roll die? (y/n): ");
				input = scanner.nextLine();
				if (input.toLowerCase().equals("y") || input.toLowerCase().equals("yes")) {
					rollAgain = true;
					dice.roll();
					System.out.println("\nYou rolled a " + dice.getFaceValue());
					System.out.print("Roll again? (y/n): ");
					input = scanner.nextLine();
					if (input.toLowerCase().equals("y") || input.toLowerCase().equals("yes")) {
						continue;
					} else {
						break;
					}
				} else if (input.toLowerCase().equals("n") || input.toLowerCase().equals("no")) {
					System.out.println("\nQuitting...");
					break;
				}
				else {
					System.out.println("Invalid input! Try again... [INP: " + input + "]");
				}
			} else {
				dice.roll();
				System.out.println("\nYou rolled a " + dice.getFaceValue());
				System.out.print("Roll again? (y/n): ");
				input = scanner.nextLine();
				if (input.toLowerCase().equals("y") || input.toLowerCase().equals("yes")) {
					continue;
				} else {
					System.out.println("Quitting...");
					break;
				}
			}
		}
		scanner.close();
	}
	
	static void printIntro() {
		System.out.println("Welcome to the dice rolling game!");
		System.out.println("Upon rolling, you will be given a random number between 1 and 6.");
		System.out.print("\n\n");
	}
}

class Dice {
	private int faceValue;
	
	public Dice() {
		faceValue = (int) ((Math.random() * (6 - 1)) + 1);
	}
	
	public int getFaceValue() {
		return faceValue;
	}
	
	public void roll() {
		faceValue = (int) ((Math.random() * (6 - 1)) + 1);
	}
	
	public void printFaceValue() {
		System.out.println(faceValue);
	}
}
