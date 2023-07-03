package com.argynsagash.leetcode.array101

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Array101 {

    @Test
    fun findMaxConsecutiveOnes() {
        val solution = MaxConsecutiveOnes()
        val arrayOne = intArrayOf(1, 1, 0, 1, 1, 1)
        val arrayTwo = intArrayOf(1, 0, 1, 1, 0, 1)

        assertEquals(3, solution.findMaxConsecutiveOnes(arrayOne))
        assertEquals(2, solution.findMaxConsecutiveOnes(arrayTwo))

        //test_version_2
        assertEquals(3, solution.findMaxConsecutiveOnesV2(arrayOne))
        assertEquals(2, solution.findMaxConsecutiveOnesV2(arrayTwo))
    }

    @Test
    fun findNumbers() {
        val solution = FindNumbersWithEvenNumberOfDigits()
        val arrayOne = intArrayOf(12, 345, 2, 6, 7896)
        val arrayTwo = intArrayOf(555, 901, 482, 1771)

        assertEquals(2, solution.findNumbers(arrayOne))
        assertEquals(1, solution.findNumbers(arrayTwo))

    }
}