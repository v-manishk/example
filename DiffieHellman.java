import java.util.*;

public class DiffieHellman {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter P = ");
		int p = sc.nextInt();
		System.out.print("Enter G = ");
		int g = sc.nextInt();

		System.out.println("P = " + p);
		System.out.println("G = " + g);

		int x = 3; //private key A user
		int y = 4; //private key B user

		int r1 = (int)(Math.pow(g, x) % p);
		int r2 = (int)(Math.pow(g, y) % p);

		int k1 = (int)(Math.pow(r2, x) % p);
		int k2 = (int)(Math.pow(r1, y) % p);

		System.out.println("K1 = " + k1);
		System.out.println("K2 = " + k2);
	}
}