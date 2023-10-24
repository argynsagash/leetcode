package com.argynsagash.leetcode.array101

//Easy
class MaxConsecutiveOnes {

    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var counter = 0
        var max = 0
        for (n in nums) {
            if (n == 1) counter++
            else {
                if (counter > max) max = counter
                counter = 0

            }
        }
        return if (counter > max) counter else max
    }

    //version_2
    fun findMaxConsecutiveOnesV2(nums: IntArray): Int {
        var max = 0
        var counter = 0
        nums.forEach {
            when (it) {
                1 -> counter++
                else -> {
                    max = counter.coerceAtLeast(max)
                    counter = 0
                }
            }
        }

        return counter.coerceAtLeast(max)
    }
}