package com.argynsagash.leetcode.arrayandstring

import com.argynsagash.leetcode.recursion.printBin
import com.argynsagash.leetcode.recursion.printBinV2
import com.argynsagash.leetcode.recursion.printTransforms
import org.junit.jupiter.api.Assertions.assertArrayEquals
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

    @Test
    fun dominantIndex() {
        val solution = LargestNumberAtLeastTwiceOfOthers()

        var givenArray = intArrayOf(3, 6, 1, 0)
        assertEquals(1, solution.dominantIndex(givenArray))

        givenArray = intArrayOf(1, 2, 3, 4)
        assertEquals(-1, solution.dominantIndex(givenArray))

        givenArray = intArrayOf(0, 0, 2, 3)
        assertEquals(-1, solution.dominantIndex(givenArray))
    }

    @Test
    fun plusOne() {
        val solution = PlusOne()
        var givenArray = intArrayOf(1, 2, 3)
        var expectedArray = intArrayOf(1, 2, 4)
        assertArrayEquals(expectedArray, solution.plusOneV2(givenArray))

        givenArray = intArrayOf(9, 1, 1)
        expectedArray = intArrayOf(9, 1, 2)
        assertArrayEquals(expectedArray, solution.plusOneV2(givenArray))

        givenArray = intArrayOf(4, 3, 2, 9)
        expectedArray = intArrayOf(4, 3, 3, 0)
        assertArrayEquals(expectedArray, solution.plusOneV2(givenArray))

        givenArray = intArrayOf(4, 3, 2, 1)
        expectedArray = intArrayOf(4, 3, 2, 2)
        assertArrayEquals(expectedArray, solution.plusOneV2(givenArray))

        givenArray = intArrayOf(9)
        expectedArray = intArrayOf(1, 0)
        assertArrayEquals(expectedArray, solution.plusOneV2(givenArray))

        givenArray = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
        expectedArray = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 1)
        assertArrayEquals(expectedArray, solution.plusOneV2(givenArray))


        givenArray = intArrayOf(
                7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7,
                7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6
        )
        expectedArray = intArrayOf(
                7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7,
                7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 7
        )
        assertArrayEquals(expectedArray, solution.plusOneV2(givenArray))

        givenArray = intArrayOf(9, 9)
        expectedArray = intArrayOf(1, 0, 0)
        assertArrayEquals(expectedArray, solution.plusOneV2(givenArray))

        givenArray = intArrayOf(8, 9, 9, 9)
        expectedArray = intArrayOf(9, 0, 0, 0)
        assertArrayEquals(expectedArray, solution.plusOneV2(givenArray))

        givenArray = intArrayOf(9, 8, 9)
        expectedArray = intArrayOf(9, 9, 0)
        assertArrayEquals(expectedArray, solution.plusOneV2(givenArray))
    }

    @Test
    fun findDiagonalOrder() {

        printBinV2(mutableListOf(), 3)
        val solution = DiagonalTraverse()

        var givenArray: Array<IntArray> =
                arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        var expectedArray = intArrayOf(1, 2, 4, 7, 5, 3, 6, 8, 9)
        assertArrayEquals(expectedArray, solution.findDiagonalOrder(givenArray))

        givenArray =
                arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        expectedArray = intArrayOf(1, 2, 3, 4)
        assertArrayEquals(expectedArray, solution.findDiagonalOrder(givenArray))
    }
}