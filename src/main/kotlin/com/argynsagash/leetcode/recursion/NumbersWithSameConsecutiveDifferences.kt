package com.argynsagash.leetcode.recursion

/**
 * Numbers With Same Consecutive Differences
 *
 * Given two integers n and k, return an array of all the integers of length n where the difference between every two consecutive digits is k. You may return the answer in any order.
 *
 * Note that the integers should not have leading zeros. Integers as 02 and 043 are not allowed.
 *
 *Constraints:
 *
 * * 2 <= n <= 9
 * * 0 <= k <= 9
 */
//СЛОЖНОСТЬ: O(2^N)
class NumbersWithSameConsecutiveDifferences {
    fun numsSameConsecDiff(n: Int, k: Int): IntArray {
        val nums = mutableListOf<Int>()
        for (i in 1..9) getAllInts(i, n, k, nums)
        return nums.toIntArray()
    }

    private fun getAllInts(numCandidate: Int, digitsCount: Int, diff: Int, nums: MutableList<Int>) {
        if (digitsCount == 1) {
            nums.add(numCandidate)
            return
        }
        val lastDigit: Int = numCandidate % 10;

        if (diff == 0) {
            val newNum = concatenateDigits(numCandidate, lastDigit)
            getAllInts(newNum, digitsCount - 1, diff, nums)
            return
        }
        if (lastDigit + diff <= 9) {
            val newNum = concatenateDigits(numCandidate, lastDigit + diff)
            getAllInts(newNum, digitsCount - 1, diff, nums)
        }
        if (lastDigit - diff >= 0) {
            val newNum = concatenateDigits(numCandidate, lastDigit - diff)
            getAllInts(newNum, digitsCount - 1, diff, nums)
        }
    }

    private fun concatenateDigits(num: Int, digit: Int) = num * 10 + digit

}