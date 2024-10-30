package coin_toss;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		printIntro();
		System.out.print("\n");
		System.out.println("Mode-1: Coin Toss Many (1)");
		System.out.println("Mode-2: Coin Toss Once (2)");
		System.out.print("Select mode: ");
		String userResp = scnr.nextLine();
		if (userResp.toLowerCase().equals("1") || userResp.toLowerCase().equals("Mode-1") || userResp.toLowerCase().equals("Coin Toss Many")) {
			System.out.print("Enter number of coin toss iterations: ");
			userResp = scnr.nextLine();
			try {
				float[] res = coinTossMany(Integer.parseInt(userResp));
				System.out.println("Heads percentage: " + res[0] + "%");
				System.out.println("Tails percentage: " + res[1] + "%");
			} catch (Exception e) {
				System.out.println("An error occured!");
				scnr.close();
				return;
			}
		} else if (userResp.toLowerCase().equals("2") || userResp.toLowerCase().equals("Mode-2") || userResp.toLowerCase().equals("Coin Toss Once")) {
			String ctOnceRes = coinTossOnce();
			System.out.println("Tossed coin! Result -> " + ctOnceRes);
		} else {
			System.out.println("Invalid input!");
		}
		scnr.close();
		return;
	}
	
	public static void printIntro() {
		System.out.println("Welcome to coin toss app");
		System.out.println("Simply select the mode of coin toss");
		System.out.println("Get results according to the selected mode");
	}
	
	public static float[] coinTossMany(int count) {
		float[] result = {0.0f, 0.0f};
		int heads = 0;
		int tails = 0;
		float headsPercent = 0.0f;
		float tailsPercent = 0.0f;
		int rnd = 0;
		for (int i = 0; i < count; i++) {
			rnd = 1 + (int)(Math.random() * ((2 - 1) + 1));
			if (rnd == 1) {
				heads++;
			} else {
				tails++;
			}
		}
		headsPercent = ((float)heads / ((float)heads + (float)tails)) * 100.0f;
		tailsPercent = ((float)tails / ((float)heads + (float)tails)) * 100.0f;
		System.out.println("Heads Count: " + heads);
		System.out.println("Tails Count: " + tails);
		result[0] = headsPercent;
		result[1] = tailsPercent;
		return result;
	}
	
	public static String coinTossOnce() {
		int rnd = 1 + (int)(Math.random() * ((2 - 1) + 1));
		if (rnd == 1) {
			return "Heads";
		} else {
			return "Tails";
		}
	}

}
