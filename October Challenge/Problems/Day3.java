/* https://leetcode.com/problems/k-diff-pairs-in-an-array/
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
a <= b
b - a == k

Example 1:
Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
*/

package Problems;

import java.util.Arrays;
import java.util.HashMap;

public class Day3 {
    // HashMap aproach
    // TC: O(n)
    // SC: O(num_of_unique_elements_in_array)
    public int findPairs1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        
        // store count of all elements
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // 3 1
        // 1 2
        // 4 1
        // 5 1
        int count = 0;
        if (k == 0) {
            for (int key: map.keySet()) {
                if (map.get(key) >= 2) {
                    count++;
                }
            }
        } else {
            for (int key: map.keySet()) {
                if (map.containsKey(key + k)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    // 2 pointer approach
    // TC: O(n) => one pass through array
    // SC: O(1) => constant space
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        
        int left = 0, right = 0, n = nums.length, count = 0;
        Arrays.sort(nums);
        // 1 1 1 4 5
        while (left < n && right < n) {
            if (left == right) {
                right++;
            } else if (nums[right] - nums[left] < k) {
                right++;
            } else if (nums[right] - nums[left] > k) {
                left++;
            } else if (nums[right] - nums[left] == k) {
                count++;
                right++;
                // to skip repeating elements
                while (right < n && nums[right] == nums[right-1]) {
                    right++;
                }
            }
        }
        
        return count;
        
        
    }
}
