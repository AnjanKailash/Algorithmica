package Adhoc;

import java.util.ArrayList;
import java.util.List;

public class FindAnagramsInAStringPerformance {

	public static void main(String[] args) {
		Solution2 sol2 = new Solution2();
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> indices = sol2.findAnagramIndices(s, p);
		
		for (int i : indices) System.out.println(i);
	}
}

class Solution2 {

	public List<Integer> findAnagramIndices(String s, String p) {
		
		int start = 0;
		int end = s.length() - p.length();
		List<Integer> list = new ArrayList<Integer>(10000);
		
		while (start <= end) {
			int nextIndex = getNextIndex(start, s.substring(start, start + p.length()), p);
			if (nextIndex == -1) {
				list.add(start);
				start++;
			} else {
				start = nextIndex;
			}
		}
		
		return list;
	}

	private int getNextIndex(int start, String s, String p) {

		int nextIndex = -1;
		int[] alphabets = new int[26];
		int[] dup_alphabets = new int[26];

		for (int i = 0; i < p.length() ; i++) {
			alphabets[p.charAt(i) - 'a'] += 1;
			dup_alphabets[p.charAt(i) - 'a'] += 1;
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (dup_alphabets[s.charAt(i) - 'a'] == 0) nextIndex = start + i + 1; //this can the index to start with in case it is not anagram
			alphabets[s.charAt(i) - 'a'] -= 1;
		}
		
		boolean isAnagram = true;
		
		for (int i = 0; i < 26; i++) {
			if (alphabets[i] != 0) {
				isAnagram = false;
				break;
			}
		}
		
		if (!isAnagram) {
			if (nextIndex == -1) nextIndex = start + 1;
		}
		
		return nextIndex;
	}
	
}