package fibonacci_numbers;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		printIntro();
		System.out.print("Enter upper limit: ");
		String uprLmt = scnr.nextLine();
		try {
			int ct = fibonacciPrinter(Integer.parseInt(uprLmt));
			System.out.println("\nTotal amount of Fibonacci numbers found within upper limit: " + ct);
		} catch(Exception e) {
			System.out.println("\nAn error occured! Err: [" + e.getMessage() + "]");
		}
		System.out.println("\n---PROGRAM END---");
		scnr.close();
	}
	
	static void printIntro() {
		System.out.println("Welcome to fibonacci sequence generator");
		System.out.println("This app will generate a fibonacci sequence upto the provided upper limit\n");
	}
	
	static int fibonacciPrinter(int upperLimit) {
		int count = 0;
		if (upperLimit <= 0) {
			System.out.println("Upper limit cannot be less or equal to zero");
			return 0;
		}
		else if (upperLimit == 1) {
			System.out.println("Fibonacci Numbers: 0, 1");
			return 2;
		} else {
			System.out.print("Fibonacci Numbers: ");
			int a = 0;
			System.out.print(a + ", ");
			int b = 1;
			System.out.print(b + ", ");
			count = 2;
			int sum = 0;
			while ((a + b) <= upperLimit) {
				sum = a + b;
				a = b;
				b = sum;
				count++;
				System.out.print(sum + ", ");
			}
		}
		return count;
	}
	
}
