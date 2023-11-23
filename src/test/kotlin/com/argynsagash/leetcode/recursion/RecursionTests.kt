package com.argynsagash.leetcode.recursion

import com.argynsagash.leetcode.arrayandstring.DiagonalTraverse
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RecursionTests {
    @Test
    fun generateParenthesis() {

        val solution = GenerateParentheses()

        var expectedArray = mutableListOf("((()))", "(()())", "(())()", "()(())", "()()()")
        Assertions.assertEquals(expectedArray, solution.generateParenthesis(3))

        expectedArray = mutableListOf("()")
        Assertions.assertEquals(expectedArray, solution.generateParenthesis(1))

        assertEquals(2, solution.getValidParenPairsCount(2))
    }

    @Test
    fun findDiagonalOrder() {

        val solution = NumbersWithSameConsecutiveDifferences()

        var expectedArray = intArrayOf(181, 292, 707, 818, 929).sorted()
        var resultArray = solution.numsSameConsecDiff(3, 7).sorted()

        for (i in expectedArray.indices) {
            assertEquals(expectedArray[i], resultArray[i])
        }
        expectedArray = intArrayOf(10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98).sorted()
        resultArray = solution.numsSameConsecDiff(2, 1).sorted()

        for (i in expectedArray.indices) {
            assertEquals(expectedArray[i], resultArray[i])
        }
    }

    @Test
    fun letterCasePermutation() {

        val solution = LetterCasePermutation()

        var expectedArray = mutableListOf("a1b2", "a1B2", "A1b2", "A1B2")
        var resultArray = solution.letterCasePermutation("a1b2")
        assertEquals(expectedArray, resultArray)

        expectedArray = mutableListOf("3z4", "3Z4")
        resultArray = solution.letterCasePermutation("3z4")
        assertEquals(expectedArray, resultArray)
    }

    @Test
    fun findTargetSumWays() {

        val solution = TargetSum()

        /**
         * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
         * -1 + 1 + 1 + 1 + 1 = 3
         * +1 - 1 + 1 + 1 + 1 = 3
         * +1 + 1 - 1 + 1 + 1 = 3
         * +1 + 1 + 1 - 1 + 1 = 3
         * +1 + 1 + 1 + 1 - 1 = 3
         */
        assertEquals(5, solution.findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3))
        assertEquals(2, solution.findTargetSumWays(intArrayOf(2, 3, 2, 1), 4))
    }

    //MAXIMUM PRODUCT OF THE LENGTH OF TWO PALINDROMIC SUBSEQUENCES
    @Test
    fun maxProduct() {
        assertEquals(9, maxProduct("leetcodecom"))
        assertEquals(1, maxProduct("bb"))
        assertEquals(25, maxProduct("accbcaxxcxx"))
        assertEquals(6, maxProduct("bxbax"))

    }

    //CLOSEST DESSERT COST
    @Test
    fun closestCost(){
        assertEquals(10, closestCost(intArrayOf(1,7),intArrayOf(3,4),10))
        assertEquals(17, closestCost(intArrayOf(2,3),intArrayOf(4,5,100),18))
        assertEquals(8, closestCost(intArrayOf(3,10),intArrayOf(2,5),9))
        assertEquals(10, closestCost(intArrayOf(10),intArrayOf(1),1))

    }

}