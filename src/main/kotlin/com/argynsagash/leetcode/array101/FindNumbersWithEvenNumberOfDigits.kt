package com.argynsagash.leetcode.array101

//Easy
class FindNumbersWithEvenNumberOfDigits {

    fun findNumbers(nums: IntArray): Int {
        var counter = 0
        for (n in nums) {
            if (n.toString().length % 2 == 0) counter++
        }
        return counter
    }

    //version_2
    fun findNumbersV2(nums: IntArray): Int = nums.filter { it.toString().length % 2 == 0 }.size

    //version_3
    fun findNumbersV3(nums: IntArray) = nums.count { it.toString().length % 2 == 0 }
}