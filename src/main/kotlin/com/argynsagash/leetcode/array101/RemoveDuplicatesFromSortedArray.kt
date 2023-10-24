package com.argynsagash.leetcode.array101

//Easy
class RemoveDuplicatesFromSortedArray {

    fun removeDuplicates(nums: IntArray): Int {
        val set = nums.toMutableSet()
        val size = set.size
        var counter = 0
        nums.forEach {
            if (set.contains(it)) {
                set.remove(it)
                nums[counter++] = it
            }
        }
        return size
    }

    //version_2
    fun removeDuplicatesV2(nums: IntArray) = nums.distinct().mapIndexed { i, n -> nums[i] = n }.size

    //version_3
    fun removeDuplicatesV3(nums: IntArray): Int {
        var counter = 0
        for (i in nums.indices)
            if (nums[i] != nums[counter]) nums[++counter] = nums[i]
        return ++counter
    }
}