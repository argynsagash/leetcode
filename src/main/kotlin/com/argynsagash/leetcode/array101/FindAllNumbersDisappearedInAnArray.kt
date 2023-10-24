package com.argynsagash.leetcode.array101

//Easy
class FindAllNumbersDisappearedInAnArray {

    fun findDisappearedNumbers(nums: IntArray): List<Int> {

        val list = (1..nums.size).toMutableList()
        for (n in nums.distinct()) list.remove(n)
        return list
    }
}