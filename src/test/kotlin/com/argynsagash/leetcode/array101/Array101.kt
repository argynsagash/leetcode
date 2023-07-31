package com.argynsagash.leetcode.array101

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Arrays.sort


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

    @Test
    fun sortedSquares() {
        val solution = SquaresOfASortedArray()

        val givenArrayOne = intArrayOf(-4, -1, 0, 3, 10)
        val givenArrayTwo = intArrayOf(-7, -3, 2, 3, 11)

        val expectedArrayOne = intArrayOf(0, 1, 9, 16, 100)
        val expectedArrayTwo = intArrayOf(4, 9, 9, 49, 121)

        assertArrayEquals(expectedArrayOne, solution.sortedSquares(givenArrayOne))
        assertArrayEquals(expectedArrayTwo, solution.sortedSquares(givenArrayTwo))
    }

    @Test
    fun duplicateZeros() {

        val solution = DuplicateZeros()

        val givenArrayOne = intArrayOf(1, 0, 2, 3, 0, 4, 5, 0)
        val givenArrayTwo = intArrayOf(1, 2, 3)
        val givenArrayThree = intArrayOf(1, 0)

        val expectedArrayOne = intArrayOf(1, 0, 0, 2, 3, 0, 0, 4)
        val expectedArrayTwo = intArrayOf(1, 2, 3)
        val expectedArrayThree = intArrayOf(1, 0)

        solution.duplicateZeros(givenArrayOne)
        assertArrayEquals(expectedArrayOne, givenArrayOne)

        solution.duplicateZeros(givenArrayTwo)
        assertArrayEquals(expectedArrayTwo, givenArrayTwo)

        solution.duplicateZeros(givenArrayThree)
        assertArrayEquals(expectedArrayThree, givenArrayThree)
    }

    @Test
    fun merge() {
        val solution = MergeSortedArray()

        var givenArrayOne = intArrayOf(1, 2, 3, 0, 0, 0)
        var numberOne = 3
        var givenArrayTwo = intArrayOf(2, 5, 6)
        var numberTwo = 3
        var expectedArrayOne = intArrayOf(1, 2, 2, 3, 5, 6)
        solution.merge(givenArrayOne, numberOne, givenArrayTwo, numberTwo)
        assertArrayEquals(expectedArrayOne, givenArrayOne)

        givenArrayOne = intArrayOf(1)
        numberOne = 1
        givenArrayTwo = intArrayOf()
        numberTwo = 0
        expectedArrayOne = intArrayOf(1)
        solution.merge(givenArrayOne, numberOne, givenArrayTwo, numberTwo)
        assertArrayEquals(expectedArrayOne, givenArrayOne)

        givenArrayOne = intArrayOf(0)
        numberOne = 0
        givenArrayTwo = intArrayOf(1)
        numberTwo = 1
        expectedArrayOne = intArrayOf(1)
        solution.merge(givenArrayOne, numberOne, givenArrayTwo, numberTwo)
        assertArrayEquals(expectedArrayOne, givenArrayOne)

    }

    @Test
    fun removeElement() {
        val solution = RemoveElement()
        var givenArrayOne = intArrayOf(3, 2, 2, 3)
        var number = 3
        var expectedArrayOne = intArrayOf(2, 2)
        assertEquals(2, solution.removeElement(givenArrayOne, number))
        sort(givenArrayOne, 0, expectedArrayOne.size)
        sort(expectedArrayOne, 0, expectedArrayOne.size)
        for (i in expectedArrayOne.indices)
            assert(givenArrayOne.get(i) === expectedArrayOne.get(i))


        //test_version_2
        givenArrayOne = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
        number = 2
        expectedArrayOne = intArrayOf(0, 1, 4, 0, 3)
        assertEquals(5, solution.removeElementV2(givenArrayOne, number))
        sort(givenArrayOne, 0, expectedArrayOne.size)
        sort(expectedArrayOne, 0, expectedArrayOne.size)
        for (i in expectedArrayOne.indices)
            assert(givenArrayOne.get(i) === expectedArrayOne.get(i))

    }

    @Test
    fun removeDuplicates() {
        val solution = RemoveDuplicatesFromSortedArray()
        var givenArrayOne = intArrayOf(1, 1, 2)
        var expectedArrayOne = intArrayOf(1, 2)
        assertEquals(2, solution.removeDuplicates(givenArrayOne))
        for (i in expectedArrayOne.indices)
            assert(givenArrayOne.get(i) === expectedArrayOne.get(i))


        givenArrayOne = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        expectedArrayOne = intArrayOf(0, 1, 2, 3, 4)
        assertEquals(5, solution.removeDuplicates(givenArrayOne))
        for (i in expectedArrayOne.indices)
            assert(givenArrayOne.get(i) === expectedArrayOne.get(i))
    }
}