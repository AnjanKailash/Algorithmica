package Adhoc;

public class RemoveDuplicatesArrayAssignment2 {
	public static void main(String[] args) {
		Solution11 sol = new Solution11();
		int[] nums = {1, 1, 2, 2, 2, 3, 5, 6};
		int newLength = sol.removeDuplicates(nums);
		for (int i = 0; i < newLength; i++) System.out.print(nums[i]+" ");
	}
}

class Solution11
{
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
        	if (nums[i] != nums[i+1]) { //find the last element in all duplicates
        		nums[j++] = nums[i];
        	}
        }
        
        nums[j++] = nums[nums.length - 1]; //last element is always non duplicate
        
        return j;
    }
}
 