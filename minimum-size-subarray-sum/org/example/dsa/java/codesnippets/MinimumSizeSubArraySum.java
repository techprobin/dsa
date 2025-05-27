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
