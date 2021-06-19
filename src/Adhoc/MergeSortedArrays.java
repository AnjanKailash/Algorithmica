package Adhoc;

public class MergeSortedArrays {

	/**
	 * Simple solution
	 * 
	 * 
	 * 
	 * https://leetcode.com/problems/merge-sorted-array/submissions/
	 * 
	 * 
	 * 
	 * Solution 1 -- simple nlogn
	 * class Solution {
		    public void merge(int[] nums1, int m, int[] nums2, int n) {
		
		        for (int i = 0; i < nums2.length; i++) {
		            nums1[i+m] = nums2[i];
		        }
		        
		        Arrays.sort(nums1);
		    }
		}
		
		
		
		
		*Solution 2 -- difficult n2
		*class Solution {
		    public void merge(int[] nums1, int m, int[] nums2, int n) {
		        int firstArrayIndex = m - 1;
		        int secondArrayIndex = 0;
		        int currentIndex = 0;
		        
		        for (secondArrayIndex = 0; secondArrayIndex < n; secondArrayIndex++) {
		            firstArrayIndex = m - 1 + secondArrayIndex;
		            currentIndex = m - 1 + secondArrayIndex;
		            if (firstArrayIndex >= 0) {
		                while (firstArrayIndex >= 0 && nums1[firstArrayIndex] > nums2[secondArrayIndex]) {
		                    firstArrayIndex--; //get that which has less value than nums2[start]
		                }
		                shiftAllOneRight(nums1, firstArrayIndex + 1);
		                nums1[firstArrayIndex+1] = nums2[secondArrayIndex];
		            } else break;
		        }
		        
		        while (currentIndex + 1 < m && secondArrayIndex < n) {
		            nums1[++currentIndex] = nums2[secondArrayIndex++];
		        }
		        
		        while (secondArrayIndex < n) {
		            nums1[++currentIndex] = nums2[secondArrayIndex++];
		        }
		    }
		    
		    public void shiftAllOneRight(int[] nums1, int index) {
		        for (int i = nums1.length - 1; i >= index && i >= 1; i--) {
		            nums1[i] = nums1[i-1];
		        }
		    }
		}
	 */
}
