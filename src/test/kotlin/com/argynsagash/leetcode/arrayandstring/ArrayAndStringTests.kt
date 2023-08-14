package com.argynsagash.leetcode.arrayandstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ArrayAndStringTests {

    @Test
    fun pivotIndex() {
        val solution = FindPivotIndex()
        var givenArray = intArrayOf(1, 7, 3, 6, 5, 6)
        assertEquals(3, solution.pivotIndexV3(givenArray))

        givenArray = intArrayOf(1, 2, 3)
        assertEquals(-1, solution.pivotIndexV3(givenArray))

        givenArray = intArrayOf(2, 1, -1)
        assertEquals(0, solution.pivotIndexV3(givenArray))

        givenArray = intArrayOf(-1, -1, -1, -1, -1, 0)
        assertEquals(2, solution.pivotIndexV3(givenArray))

        givenArray = intArrayOf(0)
        assertEquals(0, solution.pivotIndexV3(givenArray))
    }
}