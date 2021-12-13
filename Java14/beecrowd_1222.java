import java.util.Scanner;
import java.io.IOException;

public class beecrowd_1222 {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

		while(input.hasNext()) {
			int wordsToRead = input.nextInt();
			int maxLinesPerPage = input.nextInt();
			int maxCharactersPerLine = input.nextInt();

			int charactersInLine = 0;
			int lines = 0;
			int pages = 0;
			int charactersToAdd = 0;

			while(wordsToRead != 0) {
				String word = input.next();
				charactersToAdd = word.length();
				charactersInLine += charactersToAdd;

				if(charactersInLine > maxCharactersPerLine) { //The first input will never enter this statement
					lines += 1;
					charactersInLine = charactersToAdd;
				}

				if(wordsToRead > 1) {
					charactersInLine += 1; //Accounts for a space in between words
					if(charactersInLine >= maxCharactersPerLine) {
						lines += 1;
						charactersInLine = 0;
					}
				}

				wordsToRead -= 1;
			}

			if(charactersToAdd > 0) {
				lines += 1;
			}

			pages = (lines + maxLinesPerPage - 1)/maxLinesPerPage; //This is basically a round up calculation
			System.out.println(pages);
		}
	}
}
