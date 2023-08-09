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

    @Test
    fun checkIfExist() {
        val solution = CheckIfNAndItsDoubleExist()
        var givenArray = intArrayOf(10, 2, 5, 3)
        assertEquals(true, solution.checkIfExist(givenArray))

        givenArray = intArrayOf(3, 1, 7, 11)
        assertEquals(false, solution.checkIfExist(givenArray))

        givenArray = intArrayOf(7, 1, 14, 11)
        assertEquals(true, solution.checkIfExist(givenArray))

        givenArray = intArrayOf(-2, 0, 10, -19, 4, 6, -8)
        assertEquals(false, solution.checkIfExist(givenArray))


    }

    @Test
    fun validMountainArray() {
        val solution = ValidMountainArray()

        var givenArray = intArrayOf(2, 1)
        assertEquals(false, solution.validMountainArray(givenArray))

        givenArray = intArrayOf(3, 5, 5)
        assertEquals(false, solution.validMountainArray(givenArray))

        givenArray = intArrayOf(0, 3, 2, 1)
        assertEquals(true, solution.validMountainArray(givenArray))

        givenArray = intArrayOf(1, 3, 2)
        assertEquals(true, solution.validMountainArray(givenArray))

        givenArray = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
        assertEquals(false, solution.validMountainArray(givenArray))

        givenArray = intArrayOf(0, 1, 2, 4, 2, 1)
        assertEquals(true, solution.validMountainArray(givenArray))

        givenArray = intArrayOf(14, 82, 89, 84, 84)
        assertEquals(false, solution.validMountainArray(givenArray))

        givenArray = intArrayOf(14, 82, 89, 84, 79, 70, 70, 68, 67)
        assertEquals(false, solution.validMountainArray(givenArray))
    }

    @Test
    fun replaceElements() {
        val solution = ReplaceElementsWithGreatestElementOnRightSide()

        var givenArray = intArrayOf(17, 18, 5, 4, 6, 1)
        var expectedArray = intArrayOf(18, 6, 6, 6, 1, -1)
        assertArrayEquals(expectedArray, solution.replaceElements(givenArray))

        givenArray = intArrayOf(400)
        expectedArray = intArrayOf(-1)
        assertArrayEquals(expectedArray, solution.replaceElements(givenArray))

    }

    @Test
    fun moveZeroes() {
        val solution = MoveZeroes()

        var givenArray = intArrayOf(0, 1, 0, 3, 12)
        var expectedArray = intArrayOf(1, 3, 12, 0, 0)

        solution.moveZeroes(givenArray)
        assertArrayEquals(expectedArray, givenArray)

        givenArray = intArrayOf(0)
        expectedArray = intArrayOf(0)

        solution.moveZeroes(givenArray)
        assertArrayEquals(expectedArray, givenArray)

        givenArray = intArrayOf(1)
        expectedArray = intArrayOf(1)

        solution.moveZeroes(givenArray)
        assertArrayEquals(expectedArray, givenArray)

        givenArray = intArrayOf(1, 0)
        expectedArray = intArrayOf(1, 0)

        solution.moveZeroes(givenArray)
        assertArrayEquals(expectedArray, givenArray)

    }

    @Test
    fun sortArrayByParity() {
        val solution = SortArrayByParity()
        var givenArray = intArrayOf(3, 1, 2, 4)
        var result = solution.sortArrayByParity(givenArray)
        var evenCounter = 0
        for (i in givenArray) if (i % 2 == 0) evenCounter++
        for (i in 0 until evenCounter) {
            assertEquals(0, result[i] % 2)
        }

        givenArray = intArrayOf(0)
        result = solution.sortArrayByParity(givenArray)
        evenCounter = 0
        for (i in givenArray) if (i % 2 == 0) evenCounter++
        for (i in 0 until evenCounter) {
            assertEquals(0, result[i] % 2)
        }
    }

    @Test
    fun heightChecker() {
        val solution = HeightChecker()
        var givenArray = intArrayOf(1, 1, 4, 2, 1, 3)
        assertEquals(3, solution.heightChecker(givenArray))

        givenArray = intArrayOf(5, 1, 2, 3, 4)
        assertEquals(5, solution.heightChecker(givenArray))

        givenArray = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(0, solution.heightChecker(givenArray))
    }

    @Test
    fun thirdMax() {
        val solution = ThirdMaximumNumber()
        var givenArray = intArrayOf(3, 2, 1)
        assertEquals(1, solution.thirdMax(givenArray))

        givenArray = intArrayOf(1, 2)
        assertEquals(2, solution.thirdMax(givenArray))

        givenArray = intArrayOf(2, 2, 3, 1)
        assertEquals(1, solution.thirdMax(givenArray))

        givenArray = intArrayOf(1, 1, 2)
        assertEquals(2, solution.thirdMax(givenArray))
    }
}