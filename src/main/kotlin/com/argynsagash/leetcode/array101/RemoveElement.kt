package com.argynsagash.leetcode.array101

class RemoveElement {

    fun removeElement(nums: IntArray, num: Int): Int {

        val copyNums = IntArray(nums.size)
        var counter = 0
        for (number in nums.indices) {
            if (nums[number] != num) {
                copyNums[counter] = nums[number]
                counter++
            }
        }
        copyNums.copyInto(nums)
        return counter
    }

    //version_2
    fun removeElementV2(nums: IntArray, num: Int): Int {
        var counter = 0
        nums.forEach { if (it != num) nums[counter++] = it }

        return counter
    }
}