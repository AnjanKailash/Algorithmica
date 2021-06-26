package Adhoc;

public class ShortestDistanceBetweenTwoWords {
	public static void main(String[] args) {
		String[] words = {"perfect", "makes", "coding", "abc", "Practice"};//"Practice", "makes", "perfect", "Practice"};
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
		
		//move word1Index till word2 is reached twice and one step back and check the difference
		//then move word2Index till word1 is reached and one step back and check the difference
		//pick the min difference
		while (word1Index < words.length && word2Index < words.length) {

			while (word1Index < words.length) {
				int foundIndex = word1Index;
				word1Index++;
				if (word1Index < words.length && words[word1Index].equals(word1)) {
					if (Math.abs(word1Index - word2Index) < minDiff) {
						minDiff = Math.abs(word1Index - word2Index);
						foundIndex = word1Index;
					}
				} else if (word1Index < words.length && words[word1Index].equals(word2) && word1Index != word2Index) {
					word1Index = foundIndex;
					break;
				}
			}
			
			while (word2Index < words.length) {
				int foundIndex = word2Index;
				word2Index++;
				if (word2Index < words.length && words[word2Index].equals(word2)) {
					if (Math.abs(word1Index - word2Index) < minDiff) {
						minDiff = Math.abs(word1Index - word2Index);
						foundIndex = word2Index;
					}
				} else if (word2Index < words.length && words[word2Index].equals(word1) && word1Index != word2Index) {
					word2Index = foundIndex;
					break;
				}
			}
			
		}

		return minDiff;
	}
}
