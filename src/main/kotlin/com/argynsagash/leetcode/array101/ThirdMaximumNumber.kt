package com.argynsagash.leetcode.array101

class ThirdMaximumNumber {

    fun thirdMax(nums: IntArray) = if (nums.distinct().size < 3) nums.max() else nums.distinct()
        .sortedDescending()[2]

}