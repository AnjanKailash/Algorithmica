package Adhoc;

public class ReverseWordsInAString_Assignment1 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.reverseWords("algorithmica is your best guru"));
	}

}

class Solution {
    public String reverseWords(String s) {
        String reversedCharacters = reverseCharacters(s);
        return reversedWs(reversedCharacters);
    }
    
    public String reverseCharacters(String s) {
        int start = 0;
        int end = s.length() - 1;
        char [] chars = s.toCharArray();
        
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }
    
    public String reversedWs(String s) {
        String[] splits = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        
        for (int i = splits.length - 1; i >0; i--) {
            sb.append(splits[i]+" ");
        }
        sb.append(splits[0]);
        return sb.toString();
    }
}
