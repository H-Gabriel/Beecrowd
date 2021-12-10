import java.io.IOException;
import java.util.*;

public class beecrowd_1141 {
	public static class ComparatorWords implements Comparator<String> {
		@Override
		public int compare(String word1, String word2){
			if(word1.length() != word2.length()){
				return word1.length() - word2.length();
			}
			return word1.compareTo(word2);
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int loop = input.nextInt();
		while(loop != 0) {
			ArrayList<String> testCases = new ArrayList<>();
			for (int i = 0; i < loop; i++){
				testCases.add(input.next());
			}

			Collections.sort(testCases, new ComparatorWords());
			int[] sequenceSize = new int[testCases.size()];
			for (int i = 1; i < testCases.size(); i++) {
				for (int j = i-1; j >= 0; j--) {
					if(testCases.get(i).contains(testCases.get(j)) && sequenceSize[j] >= sequenceSize[i]) {
						sequenceSize[i] = sequenceSize[j] + 1;
					}
				}
			}
			Arrays.sort(sequenceSize);

			System.out.println(sequenceSize[sequenceSize.length - 1] + 1);
			loop = input.nextInt();
		}

	}

}
