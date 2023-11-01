package com.argynsagash.leetcode.recursion

/**
 * Target Sum
 *
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 *
 * Constraints:
 *
 * * 1 <= nums.length <= 20
 * * 0 <= nums [[i]] <= 1000
 * * 0 <= sum(nums [[i]]) <= 1000
 * * -1000 <= target <= 1000
 */
//СЛОЖНОСТЬ: O(2^N)
class TargetSum {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        return findTargetSumWays(nums, target, 0)
    }

    private fun findTargetSumWays(nums: IntArray, target: Int, startIndex: Int): Int {
        if (startIndex == nums.size) {
            return if (target == 0) 1 else 0
        }
        val num = nums[startIndex]
        return findTargetSumWays(nums, target - num, startIndex + 1) +
                findTargetSumWays(nums, target + num, startIndex + 1)
    }
}