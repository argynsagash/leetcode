package com.argynsagash.leetcode.array101

class SortArrayByParity {
    fun sortArrayByParity(nums: IntArray): IntArray {
        var counter = 0
        var number: Int
        for (i in nums.indices) {
            if (nums[i] % 2 == 0) {
                number = nums[counter]
                nums[counter++] = nums[i]
                nums[i] = number

            }
        }

        return nums
    }

    //version_2
    fun sortArrayByParityV2(nums: IntArray) = nums.sortedBy { it % 2 != 0 }.toIntArray()

}