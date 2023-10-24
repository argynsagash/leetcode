package com.argynsagash.leetcode.arrayandstring

//Easy
class LargestNumberAtLeastTwiceOfOthers {

    fun dominantIndex(nums: IntArray): Int {
        val max = nums.max()!!
        val numsList = nums.toMutableList()
        val index = numsList.indexOf(max)
        numsList.removeAt(index)
        val secondMax = numsList.max()!!.times(2)
        return if (max >= secondMax) index else -1

    }

    //version_2
    fun dominantIndexV2(nums: IntArray) = if (nums.sorted().dropLast(1).all { it * 2 <= nums.max()!! })
        nums.indexOf(nums.max()!!) else -1
}