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
        val expectedList1 = listOf("1", "2", "Fizz")
        val expectedList2 = listOf("1", "2", "Fizz", "4", "Buzz")
        val expectedList3 = listOf(
            "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8",
            "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"
        )

        assertEquals(expectedList1, solution.fizzBuzz(3))
        assertEquals(expectedList2, solution.fizzBuzz(5))
        assertEquals(expectedList3, solution.fizzBuzz(15))

        //test_version_2
        assertEquals(expectedList1, solution.fizzBuzzV2(3))
        assertEquals(expectedList2, solution.fizzBuzzV2(5))
        assertEquals(expectedList3, solution.fizzBuzzV2(15))
    }

    @Test
    fun maximumWealth() {
        val solution = RichestCustomerWealth()

        //init_version_1
        //same as int[] nums1 = {1, 2, 3};
        val nums1 = intArrayOf(1, 2, 3)
        val nums2 = intArrayOf(3, 2, 1)
        val array1: Array<IntArray> = arrayOf(nums1, nums2)

        //init_version_2
        //same as int [][] array2 = new int[2][3];
        val array2 = Array(2) { IntArray(3) }
        array2[0][0] = 1
        array2[0][1] = 2
        array2[0][2] = 3

        array2[1][0] = 3
        array2[1][1] = 2
        array2[1][2] = 1

        //init_version_3
        //same as int[][] array = {{1,2,3},{3,2,1}};
        val array3: Array<IntArray> = arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))
        val array4: Array<IntArray> = arrayOf(intArrayOf(1, 5), intArrayOf(7, 3), intArrayOf(3, 5))
        val array5: Array<IntArray> = arrayOf(
            intArrayOf(2, 8, 7),
            intArrayOf(7, 1, 3),
            intArrayOf(1, 9, 5)
        )

        assertEquals(6, solution.maximumWealth(array1))
        assertEquals(6, solution.maximumWealth(array2))

        //test_version_2
        assertEquals(6, solution.maximumWealthV2(array3))
        assertEquals(10, solution.maximumWealthV2(array4))
        assertEquals(17, solution.maximumWealthV2(array5))

    }

    @Test
    fun runningSum() {
        val expectedList1 = intArrayOf(1, 3, 6, 10)
        val expectedList2 = intArrayOf(1, 2, 3, 4, 5)
        val expectedList3 = intArrayOf(3, 4, 6, 16, 17)

        //same as int[] nums = {1, 2, 3, 4};
        val list1 = intArrayOf(1, 2, 3, 4)
        val list2 = intArrayOf(1, 1, 1, 1, 1)
        val list3 = intArrayOf(3, 1, 2, 10, 1)
        val solution = RunningSumOf1DArray()

        assertArrayEquals(expectedList1, solution.runningSum(list1))
        assertArrayEquals(expectedList2, solution.runningSum(list2))
        assertArrayEquals(expectedList3, solution.runningSum(list3))

    }

    @Test
    fun canConstruct() {
        val solution = RansomNote()
        assertEquals(false, solution.canConstruct("a", "b"))
        assertEquals(false, solution.canConstruct("aa", "ab"))
        assertEquals(true, solution.canConstruct("aa", "aab"))
    }

    @Test
    fun middleNode() {
        val solution = MiddleOfTheLinkedList()
        val listNode1 = ListNode(1)
        val listNode2 = ListNode(2)
        listNode1.next = listNode2
        val listNode3 = ListNode(3)
        listNode2.next = listNode3
        val listNode4 = ListNode(4)
        listNode3.next = listNode4
        val listNode5 = ListNode(5)
        listNode4.next = listNode5

        assertEquals(listNode3, solution.middleNode(listNode1))

        val listNode6 = ListNode(6)
        listNode5.next = listNode6

        assertEquals(listNode4, solution.middleNode(listNode1))

    }
}