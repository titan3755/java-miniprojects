package starter_java;

public class Main {

	public static void main(String[] args) {
		int x = 30;
		int y = 24;
		int z = 45;
		x = y + z;
		y = x + z;
		z = x + y;
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("z = " + z);
	}
}
