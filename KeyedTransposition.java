import java.util.*;

public class DiffieHellman {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//Step 1
		System.out.println("Enter Message and Key of Same Length : ");
		System.out.print("Enter message = ");
		String msg = sc.nextLine();

		System.out.print("Enter key = ");
		String key = sc.nextLine();

		//Encryption 
		System.out.println("\n\nEntered Message = " + msg);
		String en = encrypt(msg, key);
		System.out.println("Encrypted Message = " + en);

		//Decryption 
		System.out.println("\n\nEncrypted Message = " + en);
		String dc = decrypt(en, key);
		System.out.println("Decrpted Message = " + dc);
	}

	static String encrypt(String msg, String key) {
		StringBuilder ct = new StringBuilder();
		for (int i = 0; i < msg.length(); i++) {
			int n = (int)key.charAt(i) - '0' - 1;
			ct.append(msg.charAt(n));
		}
		return String.valueOf(ct);
	}

	static String decrypt(String en, String key) {
		StringBuilder dc = new StringBuilder();
		for (int i = 0; i < en.length(); i++) {
            	char c = (char)i;
            	c += '0' + 1;
            	int place = key.indexOf(c);
            	dc.append(en.charAt(place));
        	}
		return String.valueOf(dc);
	}

}