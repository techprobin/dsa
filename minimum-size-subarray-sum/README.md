**DSA - MINIMUM SIZE SUBARRAY SUM**

**Pre-requisites**:
Sliding Window Fixed Size
Advanced Algorithms
Sliding Window Variable Size
Advanced Algorithms
Prefix Sums
Advanced Algorithms
Search Array
Data Structures & Algorithms for Beginners

**QUESTION**:

Minimum Size Subarray Sum

You are given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: target = 10, nums = [2,1,5,1,5,3]

Output: 3
Explanation: The subarray [5,1,5] has the minimal length under the problem constraint.

Example 2:

Input: target = 5, nums = [1,2,1]

Output: 0
Constraints:

1 <= nums.length <= 100,000
1 <= nums[i] <= 10,000
1 <= target <= 1,000,000,000
Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).

**************************************************************************************************************************************

**SOLUTION CODE SNIPPETS**:

**JAVA**:
/*
* Copyright (c) Prabeen Pati 2025.
  */

package org.example.dsa.java.codesnippets;

public class MinimumSizeSubArraySum {

    // O(n) solution
    //Java 17
    public int minSubArrayLen(int target, int[] nums) {
        if(nums[0] >= target) return 1;
        if(nums.length == 1) return 0;
        var ans = Integer.MAX_VALUE;
        long sum = nums[0];
        int start = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] >= target) return 1;
            sum += nums[i];
            while(sum >= target && start <= i) {
                ans = Math.min(ans, i-start+1);
                sum -= nums[start];
                start++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

***************************************************************************************************************************

**Python code snippets**:
class Solution:
def minSubArrayLen(self, target: int, nums: List[int]) -> int:
l, total = 0, 0
res = float("inf")

        for r in range(len(nums)):
            total += nums[r]
            while total >= target:
                res = min(r - l + 1, res)
                total -= nums[l]
                l += 1

        return 0 if res == float("inf") else res

class Solution:
def minSubArrayLen(self, target: int, nums: List[int]) -> int:
l, total = 0, 0
res = float("inf")

        for r in range(len(nums)):
            total += nums[r]
            while total >= target:
                res = min(r - l + 1, res)
                total -= nums[l]
                l += 1

        return 0 if res == float("inf") else res


## References:
🔗 Problem Reference: [NeetCode - Minimum Size Subarray Sum](https://neetcode.io/problems/minimum-size-subarray-sum/)


