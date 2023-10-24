package com.argynsagash.leetcode.array101

//Easy
class MoveZeroes {

    fun moveZeroes(nums: IntArray) {
        var counter = 0
        for (i in nums.indices) if (nums[i] != 0) nums[counter++] = nums[i]
        while (counter < nums.size) nums[counter++] = 0
    }
}