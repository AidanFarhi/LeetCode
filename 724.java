/*
 * 724 Find Pivot Index
 * 
 * Given an array of integers nums, calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to 
 * the left of the index is equal to the sum of all the numbers strictly to the index's right.
 *
 * If the index is on the left edge of the array, then the left sum is 0 because 
 * there are no elements to the left. This also applies to the right edge of the array.
 *
 * Return the leftmost pivot index. If no such index exists, return -1.
 */
class Solution {
    public int pivotIndex(int[] nums) {
        
        // get total sum of array
        int totalSum = 0;
        for (int n : nums) totalSum += n;
        
        // start a running sum
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((totalSum - runningSum - nums[i]) == runningSum) return i;
            runningSum += nums[i];
        }
        
        return -1;
    }
}