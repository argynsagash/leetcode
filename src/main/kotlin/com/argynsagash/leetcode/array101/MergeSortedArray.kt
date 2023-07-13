package com.argynsagash.leetcode.array101

class MergeSortedArray {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {

        var firstIndex = m
        var secondIndex = 0
        while (firstIndex < nums1.size) {
            nums1[firstIndex] = nums2[secondIndex]
            firstIndex++
            secondIndex++
        }
        nums1.sort()
    }
}