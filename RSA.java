import java.util.*;

public class DiffieHellman {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//Step 1
		System.out.print("Enter P = ");
		int p = sc.nextInt();
		System.out.print("Enter Q = ");
		int q = sc.nextInt();

		//Step 2
		int n = p * q;
		int piOfN = (p - 1) * (q - 1);
		System.out.println("N = " + n);
		System.out.println("$(N) = " + piOfN);

		//Step 3
		int e = selectE(piOfN);
		System.out.println("E = " + e);

		//Step 4
		int d = selectD(e, piOfN);
		System.out.println("D = " + d);

		//Encryption 
		System.out.print("Enter Message = ");
		int M = sc.nextInt(); //message
		System.out.println("Message = " + M);
		double en = encrypt(M, e, n);
		System.out.println("Encrypted = " + en);

		//Decryption 
		System.out.println("\nEncrypted Message = " + en);
		double dc = decrypt(en, d, n);
		System.out.println("Decrpted Message = " + dc);
	}

	static double encrypt(int M, int e, int n) {
		
		return (Math.pow(M, e) % n);
	}

	static double decrypt(double en, int d, int n) {
		
		return (Math.pow(en, d) % n);
	}

	static int selectE(int piOfN) {
		int e = 2;
		for (e = 2; e < piOfN; e++) {
			if(gcd(piOfN, e) == 1) {
				break;
			}
		}
		return e;
	}

	static int selectD(int e, int piOfN) {
		int i = 0;
		for (i = 1; i <= 9; i++) {
			if(((i * e) % piOfN) == 1) {
				break;
			}
		}
		return i;
	}

	static int gcd(int piOfN, int e) {
		while(piOfN != e) {  
			if(piOfN > e) {
				piOfN = piOfN - e; 
			} else {  
				e = e - piOfN;  
			}
		} 
		return e; 
	}


}