package com.argynsagash.leetcode.array101

class HeightChecker {

    fun heightChecker(heights: IntArray) =
        heights.sorted().filterIndexed { i, n -> n != heights[i] }.size
}