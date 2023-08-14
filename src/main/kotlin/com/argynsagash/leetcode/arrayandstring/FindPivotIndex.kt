package com.argynsagash.leetcode.arrayandstring

class FindPivotIndex {

    fun pivotIndex(nums: IntArray): Int {
        if (nums.size == 1) return 0
        var leftSum = 0
        var rightSum = 0
        //1, 7, 3, 6, 5, 6
        for (i in nums.indices) {

            // middleIndex++
            rightSum = sumFrom(nums, 1 + i)

            if (leftSum == rightSum) return i
            if (leftSum == 0 && rightSum == 0) return nums.size - 1
            if (rightSum == 0 && leftSum == 0) return 0
            leftSum += nums[i]

        }

        return -1
    }

    private fun sumFrom(numsArray: IntArray, from: Int): Int {
        if (from == numsArray.size) return 0
        var rightSum = 0
        for (j in from until numsArray.size) {
            rightSum += numsArray[j]
        }
        return rightSum
    }

    //version_2
    fun pivotIndexV2(nums: IntArray): Int {
        val total = nums.sum()

        var sum = 0
        var i = 0
        while (i < nums.size){
            if (sum * 2 == total - nums[i]) return i
            sum += nums[i]
            i++
        }
        return -1
    }

    //version_3
    fun pivotIndexV3(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val pivot = -1
        var leftSum = 0
        var rightSum = nums.sum()

        nums.forEachIndexed{ idx, num ->
            rightSum -= num
            if (leftSum == rightSum) {
                return idx
            }
            leftSum += num
        }
        return pivot
    }
}