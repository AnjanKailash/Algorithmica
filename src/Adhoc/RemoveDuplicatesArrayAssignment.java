/**
 * 
 * 
 * 
 * 
 * 
 * class Solution {
    public int removeDuplicates(int[] nums) {   
        int originalLength = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1] && nums[i] != Integer.MIN_VALUE) {
                int j = i + 1;
                int count = 0;
                while (j < nums.length && nums[i] == nums[j]) {
                    nums[j] = Integer.MIN_VALUE;
                    originalLength--;
                    j++;
                    count++;
                }
                i += count;
            }
        }
        removeNegatives(nums);
        return originalLength;
    }
    
    public void removeNegatives(int[] nums) {
        int negIndex = 0;
        int posIndex = 0;
        int i = 0;
        while (i < nums.length && nums[i] != Integer.MIN_VALUE) i++;
        
        //we know first index is never min value
        posIndex = i;
        
        while (negIndex < nums.length && posIndex < nums.length) {
            while (negIndex < nums.length && nums[negIndex] != Integer.MIN_VALUE) negIndex++;
            while (posIndex < nums.length && nums[posIndex] == Integer.MIN_VALUE) posIndex++;
            if (posIndex < nums.length && negIndex < nums.length) {
                int temp = nums[negIndex];
                nums[negIndex] = nums[posIndex];
                nums[posIndex] = temp;
            }
        }
    }
}
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
