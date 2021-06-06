package Adhoc;

import java.util.Arrays;
import java.util.Random;

public class RotateArrayKTimes {

	//Time theta(kn) space O(1)
	public static void rotateArrayKTimesNaive(int[] in, int k) {
		
		for (int i=1; i <= k; i++) {
			int lastElement = in[in.length-1];
			for (int j = in.length -1; j > 0 ; j--) {
				in[j] = in[j-1];
			}
			in[0] = lastElement;
		}
	}
	
	//Time theta(n) space O(n)
	public static void rotateArrayAuxilirySpace(int[] in, int k) {
		
		int[] aux = new int[in.length];
		
		for (int i = 0; i < in.length; i++) {
			aux[(i+k)%(in.length)] = in[i];
			System.out.println("Index "+((i+k)%(in.length))+" is set to: "+aux[(i+k)%(in.length)]);
		}
		
		for (int j = 0; j < in.length; j++) {
			in[j] = aux[j];
		}
	}
	
	//Time theta(n) space O(1)
	public static void rotateArrayBySwapping(int[] in, int k) {
		reverse(in, 0, in.length-1);
		reverse(in, k+1, in.length-1);
		reverse(in, 0, k-1);
	}
	
	private static void reverse(int[] in, int first, int last) {
		while (first < last) {
			int temp = in[first];
			in[first] = in[last];
			in[last] = temp;
			first++;
			last--;
		}
	}
	
	public static void main(String[] args) {
		
		int length = Integer.parseInt(args[0]);
		int[] in = new int[length];
		Random r = new Random();
		
		for (int l = 0; l < length; l++) {
			in[l] = r.nextInt(length) + 1;
		}
		
		int k = r.nextInt(length) + 1;
		
		System.out.println("Array: "+Arrays.toString(in));
		//rotateArrayKTimesNaive(in, k);
		//rotateArrayAuxilirySpace(in, k);
		rotateArrayBySwapping(in, k);
		System.out.println(k);
		System.out.println(Arrays.toString(in));
	}

}
