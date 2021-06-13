package Adhoc;

import java.util.Arrays;

public class FindDuplicate {

	//T.C theta(n2) SC: O(1)
	public static int findDuplicateElementBruteforce(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] == arr[j]) return arr[i];
			}
		}
		return Integer.MIN_VALUE;
	}
	
	//T.C theta(nlogn) SC: O(1)
	public static int findDuplicateElementSorting(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length-1; i++) if (arr[i] == arr[i+1]) return arr[i];
		return Integer.MIN_VALUE;
	}
	
	//T.C theta(n) SC: O(n)
	public static int findDuplicateUsingAuxilaryArray(int[] arr) {
		boolean[] boo = new boolean[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (boo[arr[i]] == true) return arr[i];
			boo[arr[i]] = true;
		}
		return Integer.MIN_VALUE;
	}
	
	//T.C theta(n) SC: O(1)
	public static int findDuplicateWithOutExtraSpace(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i])] < 0) return Math.abs(arr[i]);
			arr[Math.abs(arr[i])] *= -1;
		}
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{ 1, 3, 4, 6, 2, 5, 7, 8, 9, 9 }; 
		System.out.println(findDuplicateElementBruteforce(arr));
		System.out.println(findDuplicateElementSorting(arr));
		System.out.println(findDuplicateUsingAuxilaryArray(arr));
		System.out.println(findDuplicateWithOutExtraSpace(arr));
	}
}
