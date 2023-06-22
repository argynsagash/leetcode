package com.argynsagash.leetcode.beginner

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Beginner {

    @Test
    fun numberOfSteps() {
        val solution = NumberOfStepsToReduceANumberToZero()
        assertEquals(6, solution.numberOfSteps(14))
        assertEquals(4, solution.numberOfSteps(8))
        assertEquals(12, solution.numberOfSteps(123))
    }

    @Test
    fun fizzBuzz() {

        val solution = FizzBuzz()
        val list1 = listOf("1", "2", "Fizz")
        val list2 = listOf("1", "2", "Fizz", "4", "Buzz")
        val list3 = listOf(
            "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8",
            "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"
        )
        assertEquals(list1, solution.fizzBuzz(3))
        assertEquals(list2, solution.fizzBuzz(5))
        assertEquals(list3, solution.fizzBuzz(15))

        assertEquals(list1, solution.fizzBuzzTwo(3))
        assertEquals(list2, solution.fizzBuzzTwo(5))
        assertEquals(list3, solution.fizzBuzzTwo(15))
    }

    @Test
    fun maximumWealth() {
        val solution = RichestCustomerWealth()

        //version_1
        //same as int[] nums1 = {1, 2, 3};
        val nums1 = intArrayOf(1, 2, 3)
        val nums2 = intArrayOf(3, 2, 1)
        val array1: Array<IntArray> = arrayOf(nums1, nums2)

        //version_2
        //same as int [][] array2 = new int[2][3];
        val array2 = Array(2) { IntArray(3) }
        array2[0][0] = 1
        array2[0][1] = 2
        array2[0][2] = 3

        array2[1][0] = 3
        array2[1][1] = 2
        array2[1][2] = 1

        //version_3
        //same as int[][] array = {{1,2,3},{3,2,1}};
        val array3: Array<IntArray> = arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))
        val array4: Array<IntArray> = arrayOf(intArrayOf(1, 5), intArrayOf(7, 3), intArrayOf(3, 5))
        val array5: Array<IntArray> = arrayOf(
            intArrayOf(2, 8, 7),
            intArrayOf(7, 1, 3),
            intArrayOf(1, 9, 5)
        )

        assertEquals(6, solution.maximumWealth2(array3))
        assertEquals(10, solution.maximumWealth2(array4))
        assertEquals(17, solution.maximumWealth2(array5))

        assertEquals(6, solution.maximumWealth(array1))
        assertEquals(6, solution.maximumWealth(array2))
    }

    @Test
    fun runningSum() {
        val list1 = intArrayOf(1, 3, 6, 10)
        val list2 = intArrayOf(1, 2, 3, 4, 5)
        val list3 = intArrayOf(3, 4, 6, 16, 17)

        //same as int[] nums = {1, 2, 3, 4};
        val nums = intArrayOf(1, 2, 3, 4)
        val nums2 = intArrayOf(1, 1, 1, 1, 1)
        val nums3 = intArrayOf(3, 1, 2, 10, 1)
        val solution = RunningSumOf1DArray()

        assertArrayEquals(list1, solution.runningSum(nums))
        assertArrayEquals(list2, solution.runningSum(nums2))
        assertArrayEquals(list3, solution.runningSum(nums3))

    }
}