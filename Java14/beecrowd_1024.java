import java.io.IOException;
import java.util.Scanner;

public class beecrowd_1024 {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		int loop = input.nextInt();
		input.nextLine();

		for (int j = 0; j < loop; j++) {
			String test = input.nextLine();
			char[] c = new char[test.length()];
			for (int i = 0; i < c.length; i++) {
				c[i] = test.charAt(i);
				if((c[i] >= 65 && c[i] <= 90)||(c[i] >= 97 && c[i] <= 122)){
					 c[i] = (char)((int)c[i] + 3);
				 }
			}
			for (int i = 0; i < c.length/2; i++) {
				char temp = c[i];
				int c1 = test.length() - i - 1;
				c[i] = c[c1];
				c[c1] = temp;
			}

			for (int i = c.length/2; i < c.length; i++) {
				c[i] = (char)((int)c[i] - 1);
			}

			String finalText = "";
			for (int i = 0; i < c.length; i++){
				finalText += c[i];
			}

			System.out.println(finalText);

		}

	}

}
