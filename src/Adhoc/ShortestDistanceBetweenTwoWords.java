package Adhoc;

public class ShortestDistanceBetweenTwoWords {
	public static void main(String[] args) {
		String[] words = {"Practice", "makes", "coding", "abc", "Practice", "makes", "perfect"};
		/*Assumption both words are present in the array*/
		String word1 = "Practice";
		String word2 = "perfect";
		System.out.println("Shortest distance: "+getShortestDistance(words, word1, word2));
	}

	private static int getShortestDistance(String[] words, String word1, String word2) {
		
		int word1Index = 0;
		int word2Index = 0;
		int minDiff = 0;
		
		boolean foundWord1 = false;
		boolean foundWord2 = false;
		//get the first occurrences words
		for (int i = 0; i < words.length; i++) {
			if (!words[i].equals(word1) && !foundWord1) {
				word1Index++;
			} else foundWord1 = true;
			if (!words[i].equals(word2) && !foundWord2) {
				word2Index++;
			} else foundWord2 = true;
			if (foundWord1 && foundWord2) break;
		}
		
		minDiff = Math.abs(word1Index - word2Index);
		
		//move word1Index and check the difference
		//then move word2Index and check the difference
		//pick the min difference
		while (word1Index < words.length && word2Index < words.length) {
			word1Index++;
			while (word1Index < words.length && !words[word1Index].equals(word1)) word1Index++;
			if (word1Index < words.length && word2Index < words.length) {
				if (Math.abs(word1Index - word2Index) < minDiff) minDiff = Math.abs(word1Index - word2Index);
			}
			
			word2Index++;
			while (word2Index < words.length && !words[word2Index].equals(word2)) word2Index++;
			if (word2Index < words.length && word1Index < words.length) {
				if (Math.abs(word1Index - word2Index) < minDiff) minDiff = Math.abs(word1Index - word2Index);
			}
		}

		return minDiff;
	}
}
