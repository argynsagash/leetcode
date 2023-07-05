package com.argynsagash.leetcode.array101

class SquaresOfASortedArray {

    fun sortedSquares(nums: IntArray) = nums.map { it * it }.sorted().toIntArray()

}