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

fun main() {

    //same as int[] nums = {1, 2, 3, 4};
    val nums = intArrayOf(1, 2, 3, 4)
    val nums2 = intArrayOf(1, 1, 1, 1, 1)
    val nums3 = intArrayOf(3, 1, 2, 10, 1)
    val solution = RunningSumOf1DArray()
    solution.runningSum(nums).forEach { i -> print("$i ") }
    println()
    solution.runningSum(nums2).forEach { i -> print("$i ") }
    println()
    solution.runningSum(nums3).forEach { i -> print("$i ") }


}