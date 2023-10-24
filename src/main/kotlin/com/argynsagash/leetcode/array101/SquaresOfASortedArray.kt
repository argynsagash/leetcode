package com.argynsagash.leetcode.array101

//Easy
class SquaresOfASortedArray {

    fun sortedSquares(nums: IntArray) = nums.map { it * it }.sorted().toIntArray()

}