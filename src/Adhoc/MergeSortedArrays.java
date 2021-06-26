package Adhoc;

import java.util.Arrays;

public class MergeSortedArrays {
	public static void main(String[] args) {
		int[] array1 = {1, 2, 3, 4, 10, 20, 50, 60, 70, 0, 0, 0};
		int[] array2 = {5, 10, 20};
		mergeArraysInOrder(array1, 9, array2, 3);
		System.out.println(Arrays.toString(array1));
	}

	private static void mergeArraysInOrder(int[] array1, int m, int[] array2, int n) {
		int insertIndex = array1.length - 1;
		int array1Index = m-1;
		int array2Index = n-1;
		
		while (array1Index >= 0 && array2Index >= 0) {
			if (array1[array1Index] >= array2[array2Index]) {
				array1[insertIndex--] = array1[array1Index--];
			} else array1[insertIndex--] = array2[array2Index--];
		}

		while (array1Index >= 0) {
			array1[insertIndex--] = array1[array1Index--];
		}
		
		while (array2Index >= 0) {
			array2[insertIndex--] = array1[array2Index--];
		}
	}
}
