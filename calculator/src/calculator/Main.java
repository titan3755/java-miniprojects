package calculator;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		printIntro();
		Scanner scnr = new Scanner(System.in);
		System.out.print("\nEnter first number: ");
		String numOne = scnr.nextLine();
		System.out.print("\nEnter second number: ");
		String numTwo = scnr.nextLine();
		System.out.print("\nEnter operation (\'+\', \'-\', \'*\', \'/\'): ");
		String optr = scnr.nextLine();
		try {
			float expr = calculate(Float.parseFloat(numOne), Float.parseFloat(numTwo), optr);
			System.out.println("\nResult: " + expr);
		} catch (Exception e) {
			System.out.println("\nAn error occured! Err: [" + e.getMessage() + "]");
		}
		scnr.close();
	}
	
	static void printIntro() {
		System.out.println("Welcome to the calculator!");
        System.out.println("Enter an expression to calculate.");
        System.out.println("Supported operators: +, -, *, /");
        System.out.println("Type 'exit' to quit.");
	}

	static float calculate(float num1, float num2, String optr) {
		float temp_num_store;
		switch (optr) {
		case "+":
			temp_num_store = num1 + num2;
			break;
		case "-":
			temp_num_store = num1 - num2;
			break;
		case "*":
			temp_num_store = num1 * num2;
			break;
		case "/":
			temp_num_store = num1 / num2;
			break;
		default:
			temp_num_store = 0.0f;
		}
		return temp_num_store;
	}
}
