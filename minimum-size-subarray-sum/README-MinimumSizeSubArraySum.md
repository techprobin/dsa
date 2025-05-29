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
1. Brute Force
   public class Solution {
   public int minSubArrayLen(int target, int[] nums) {
   int n = nums.length;
   int res =  Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int curSum = 0, j = i;
            while (j < n) {
                curSum += nums[j];
                if (curSum >= target) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
                j++;
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
   }
   }
   Time & Space Complexity
   Time complexity:
   O
   (
   n
   2
   )
   O(n
   2
   )
   Space complexity:
   O
   (
   1
   )
   O(1) extra space.
2. Sliding Window
   public class Solution {
   public int minSubArrayLen(int target, int[] nums) {
   int l = 0, total = 0;
   int res = Integer.MAX_VALUE;

        for (int r = 0; r < nums.length; r++) {
            total += nums[r];
            while (total >= target) {
                res = Math.min(r - l + 1, res);
                total -= nums[l];
                l++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
   }
   }
   Time & Space Complexity
   Time complexity:
   O
   (
   n
   )
   O(n)
   Space complexity:
   O
   (
   1
   )
   O(1) extra space.
3. Prefix Sum + Binary Search
   public class Solution {
   public int minSubArrayLen(int target, int[] nums) {
   int n = nums.length;
   int[] prefixSum = new int[n + 1];
   for (int i = 0; i < n; i++) {
   prefixSum[i + 1] = prefixSum[i] + nums[i];
   }

        int res = n + 1;
        for (int i = 0; i < n; i++) {
            int l = i, r = n;
            while (l < r) {
                int mid = (l + r) / 2;
                int curSum = prefixSum[mid + 1] - prefixSum[i];
                if (curSum >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (l != n) {
                res = Math.min(res, l - i + 1);
            }
        }

        return res % (n + 1);
   }
   }
   Time & Space Complexity
   Time complexity:
   O(nlogn)
   Space complexity:
   O(n)

***************************************************************************************************************************

**Python code snippets**:

1. Brute Force
   class Solution:
   def minSubArrayLen(self, target: int, nums: List[int]) -> int:
   n = len(nums)
   res = float("inf")

        for i in range(n):
            curSum = 0
            for j in range(i, n):
                curSum += nums[j]
                if curSum >= target:
                    res = min(res, j - i + 1)
                    break
        
        return 0 if  res == float("inf") else res
Time & Space Complexity
Time complexity:
O
(
n
2
)
O(n
2
)
Space complexity:
O
(
1
)
O(1) extra space.
2. Sliding Window
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
Time & Space Complexity
Time complexity:
O
(
n
)
O(n)
Space complexity:
O
(
1
)
O(1) extra space.
3. Prefix Sum + Binary Search
   class Solution:
   def minSubArrayLen(self, target: int, nums: List[int]) -> int:
   n = len(nums)
   prefixSum = [0] * (n + 1)
   for i in range(n):
   prefixSum[i + 1] = prefixSum[i] + nums[i]

        res = n + 1
        for i in range(n):
            l, r = i, n
            while l < r:
                mid = (l + r) // 2
                curSum = prefixSum[mid + 1] - prefixSum[i]
                if curSum >= target:
                    r = mid
                else:
                    l = mid + 1
            if l != n:
                res = min(res, l - i + 1)

        return res % (n + 1)
Time & Space Complexity
Time complexity:
O
(
n
log
⁡
n
)
O(nlogn)
Space complexity:
O
(
n
)
O(n)

___________________
## References:
🔗 Problem Reference: [NeetCode - Minimum Size Subarray Sum](https://neetcode.io/problems/minimum-size-subarray-sum/)
