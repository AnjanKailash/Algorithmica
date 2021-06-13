package Adhoc;

import java.util.Arrays;

public class AnagramCheck {

	/**
	 * 
	 * @param s1 --> first string
	 * @param s2 --> second string
	 * @return --> boolean whether s1 and s2 are anagrams
	 * ------------------Time complexity TC: theta(n2) SC: O(1)--------------------
	 */
	public static boolean anagramCheckBruteForce(String s1, String s2) {
		
		if (s1.length() != s2.length()) return false;
		
		//convert both into character arrays
		char[] s1s = s1.toCharArray();
		char[] s2s = s2.toCharArray();
		int[] alreadyFoundIndex = new int[s1s.length]; //store the indexes which are already visited
		
		for (int i = 0; i < s1s.length; i++) {
			boolean found = false;
			for (int j = 0; j < s2s.length; j++) {
				if (alreadyFoundIndex[j] != 0) continue;
				if (s1s[i] == s2s[j]) {
					alreadyFoundIndex[j] = 1;
					found = true;
					break; //don't check later indices if already found
				}
			}
			if (!found) return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 * ------------------TC: theta(nlogn) SC:O(1)---------------------------------------------
	 */
	public static boolean anagramCheckSortingAndScanning(String s1, String s2) {
		
		if (s1.length() != s2.length()) return false;
		
		char[] s1s = s1.toCharArray();
		char[] s2s = s2.toCharArray();
		
		Arrays.sort(s1s);
		Arrays.sort(s2s);
		
		for (int i = 0; i < s1s.length; i++) {
			if (s1s[i] != s2s[i]) return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 * ---------------TC: theta(n) SC: O(1)--------------------
	 */
	public static boolean anagramCheckFrequencyMethod(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		
		char[] s1s = s1.toCharArray();
		char[] s2s = s2.toCharArray();
		int[] frequencies = new int[26];
		
		//get the frequencies of s1
		for (int i = 0; i < s1s.length; i++) {
			frequencies[s1s[i] - 'a'] += 1; 
		}
		
		//subtract 1 from the index when found in s2s
		for (int j = 0; j < s2s.length; j++) {
			if (frequencies[s2s[j] - 'a'] <= 0) return false;
			frequencies[s2s[j] - 'a'] -= 1;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String s1 = args[0];
		String s2 = args[1];
		System.out.println("Anagrams: "+anagramCheckBruteForce(s1, s2));
		System.out.println("Anagrams: "+anagramCheckSortingAndScanning(s1, s2));
		System.out.println("Anagrams: "+anagramCheckFrequencyMethod(s1, s2));
	}

}
