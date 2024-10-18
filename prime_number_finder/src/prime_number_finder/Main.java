package prime_number_finder;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		printIntro();
		System.out.print("Enter upper limit of prime numbers: ");
		String uprLmt = scnr.nextLine();
		try {
			if (Integer.parseInt(uprLmt) < 2) {
				System.out.println("No prime number less than 2");
				scnr.close();
				return;
			} else if (Integer.parseInt(uprLmt) == 2) {
				System.out.println("2 is the only prime number in this range");
				scnr.close();
				return;
			}
			int pC = primeFinder(Integer.parseInt(uprLmt));
			System.out.println("\nTotal primes found: " + pC);
		} catch (Exception e) {
			System.out.println("\nAn error occured! Err: [" + e.getMessage() + "]");
		}
		System.out.println("All prime numbers found upto upper limit: " + uprLmt);
		scnr.close();
	}
	
	static void printIntro() {
		System.out.println("Welcome to prime number finder!");
		System.out.println("Input the upper limit of the numbers");
		System.out.println("The prime numbers will be found upto that limit");
		System.out.println("\n");
	}
	
	static int primeFinder(int upperLimit) {
		boolean toAdd = true;
		int toRoot = 0;
		int primeCount = 1;
		for (int i = 3; i <= upperLimit; i++) {
			toRoot = (int)Math.floor(Math.sqrt(i));
			for (int k = 1; k <= toRoot; k++) {
				if (i % k == 0 && k != 1 && k != i) {
					toAdd = false;
					break;
				}
			}
			if (toAdd) {
				primeCount++;
			}
			toAdd = true;
		}
		return primeCount;
	}
	
	static void debugger(String msg) {
		System.out.println(msg);
	}
}
