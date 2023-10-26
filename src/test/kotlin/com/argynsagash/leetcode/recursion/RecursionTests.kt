package com.argynsagash.leetcode.recursion

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RecursionTests {
    @Test
    fun generateParenthesis() {

        val solution = GenerateParentheses()

        var expectedArray = mutableListOf("((()))", "(()())", "(())()", "()(())", "()()()")
        Assertions.assertEquals(expectedArray, solution.generateParenthesis(3))

        expectedArray = mutableListOf("()")
        Assertions.assertEquals(expectedArray, solution.generateParenthesis(1))
    }
}