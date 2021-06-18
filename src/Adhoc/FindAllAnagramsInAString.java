package Adhoc;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		List<Integer> list = s.findAnagrams("cbaebabacd", "abc");
		for (int l : list) {
			System.out.print(l+" ");
		}
	}

}



class Solution1 {
    
	public List<Integer> findAnagrams(String s, String p) {
    
		int start = 0;
		int last = s.length() - p.length();
		List<Integer> list = new ArrayList<Integer>();	
		while (start <= last) {
			String s_ = s.substring(start, start+p.length());
			boolean isAnagram = isAnagram(s_, p);
			if (isAnagram) {
				list.add(start);
				start++;
			} else { //get the index
				start += getTheIndex(s_, p) + 1;
			}
		}
		
		return list;
    }

	private int getTheIndex(String s_, String p) {
		int lastIndex = 0;
		for (int i = 0; i < s_.length(); i++) {
			if (p.indexOf(s_.charAt(i)) < 0) {
				lastIndex = i;
			}
		}
		return lastIndex;
	}

	private boolean isAnagram(String s, String p) {

		int[] alphabets = new int[26];
		boolean isAnagram = true;
		
		for (int i = 0; i < s.length(); i++) {
			alphabets[s.charAt(i) - 'a'] += 1;
		}
		
		for (int i = 0; i < p.length(); i++) {
			alphabets[p.charAt(i) - 'a'] -= 1;
		}
		
		for (int i = 0; i < 26; i++) {
			if (alphabets[i] != 0) {
				isAnagram = false;
				break;
			}
		}

		return isAnagram;
	}
    
}