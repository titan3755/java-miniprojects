package rps;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		try {
			int difficulty = 0;
			int turnLimit = 0;
			boolean gameWon = false;
			boolean gameLost = false;
			boolean gameDraw = false;
			boolean gameRunning = true;
			String state;
			printIntro();
			while (true) {
				System.out.print("\n\n");
				System.out.println("Please select a difficulty setting");
				System.out.println("1. Easy");
				System.out.println("2. Medium");
				System.out.println("3. Hard");
				System.out.println("4. Impossible");
				System.out.print("Please enter the number corresponding to the difficulty setting: ");
				String tempDifficulty = scnr.nextLine();
				if (tempDifficulty.equals("1")) {
					difficulty = 5;
					break;
				} else if (tempDifficulty.equals("2")) {
					difficulty = 10;
					break;
				} else if (tempDifficulty.equals("3")) {
					difficulty = 15;
					break;
				} else if (tempDifficulty.equals("4")) {
					difficulty = 20;
					break;
				} else {
					System.out.println("Invalid input. Please try again.");
					continue;
				}
			}
			while (true) {
				System.out.print("\n\n");
				System.out.println("Please select a turn limit");
				System.out.println("1. 10 turns");
				System.out.println("2. 20 turns");
				System.out.println("3. 30 turns");
				System.out.println("4. 40 turns");
				System.out.print("Please enter the number corresponding to the turn limit: ");
				String tempTurnLimit = scnr.nextLine();
				if (tempTurnLimit.equals("1")) {
					turnLimit = 10;
					break;
				} else if (tempTurnLimit.equals("2")) {
					turnLimit = 20;
					break;
				} else if (tempTurnLimit.equals("3")) {
					turnLimit = 30;
					break;
				} else if (tempTurnLimit.equals("4")) {
					turnLimit = 40;
					break;
				} else {
					System.out.println("Invalid input. Please try again.");
					continue;
				}
			}
			Game game = new Game(difficulty, turnLimit);
			while (gameRunning) {
				state = game.checkGameOver();
				if (!state.equals(game.getGameStateValues()[3])) {
					gameRunning = false;
					if (game.checkGameOver().equals(game.getGameStateValues()[0])) {
						gameWon = true;
					} else if (game.checkGameOver().equals(game.getGameStateValues()[1])) {
						gameLost = true;
					} else {
						gameDraw = true;
					}
					continue;
				} else {
					game.roll();
					System.out.print("\n\n");
					System.out.print("Please enter your choice (rock, paper, scissors): ");
					String userResp = scnr.next();
					if (userResp.toLowerCase().equals(game.getRpsValues()[0])
							|| userResp.toLowerCase().equals(game.getRpsValues()[1])
							|| userResp.toLowerCase().equals(game.getRpsValues()[2])) {
						state = game.check(userResp);
						System.out.println("Computer chose: " + game.getRpsValues()[game.getRpsState() - 1]);
						System.out.println("Your choice: " + userResp);
						System.out.println("Result: " + state);
						System.out.println("Score: " + game.getScore());
						System.out.println("Score needed to win: " + game.getDifficulty());
						System.out.println("Turns: " + game.getTurns() + "/" + game.getTurnLimit());
					} else {
						System.out.println("Invalid input. Please try again.");
						game.unroll();
						continue;
					}
				}
			}
			if (gameWon) {
				System.out.println("Congratulations! You have won the game!");
			} else if (gameLost) {
				System.out.println("Sorry! You have lost the game!");
			} else if (gameDraw) {
				System.out.println("The game has ended in a draw!");
			} else {
				System.out.println("An error occurred. Please try again.");
			}
		} catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
        }
		scnr.close();
	}
	
	static void printIntro() {
		System.out.println("Welcome to Rock-Paper-Scissors game!");
		System.out.println("The computer will select a random number");
		System.out.println("It will be translated to either rock, paper or scissors");
		System.out.println("You will be asked for input in the terminal");
		System.out.println("If your input matches that of the computer, your score will increase");
		System.out.println("If not, score will decrease by a fixed amount");
		System.out.println("You will have to gain a fixed number of score to win");
		System.out.println("The fixed number of score will be determined by a difficulty setting");
		System.out.println("Enjoy the game!");
	}
	
}
