package com.argynsagash.leetcode.beginner

class RunningSumOf1DArray {

    fun runningSum(nums: IntArray): IntArray {
        val array: MutableList<Int> = mutableListOf()
        var number = 0
        for (num in nums) {
            number += num
            array.add(number)
        }
        return array.toIntArray()
    }
}
