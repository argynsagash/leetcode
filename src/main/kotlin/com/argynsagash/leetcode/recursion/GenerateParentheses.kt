package com.argynsagash.leetcode.recursion

/**
 * Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
class GenerateParentheses {

    fun generateParenthesis(n: Int): List<String> {
        val parenthesisList = mutableListOf<String>()
        generateParenthesis("", n, n, parenthesisList)
        return parenthesisList
    }

    private fun generateParenthesis(parenCandidate: String, left: Int, right: Int, result: MutableList<String>) {
        //1-определить все базовые случаи
        if (left == -1 || left > right) return
        if (left == 0 && right == 0) {
            result.add(parenCandidate)
            return
        }
        //3-посчитать количество стрелок в дереве
        //4-определить задачу меньшего размера
        generateParenthesis(parenCandidate + "(", left - 1, right, result)
        generateParenthesis(parenCandidate + ")", left, right - 1, result)
    }

    fun getValidParenPairsCount(parenthesisCount: Int): Int {
        return getValidParenPairsCount(parenthesisCount, parenthesisCount)
    }

    private fun getValidParenPairsCount(left: Int, right: Int): Int {
        if (left == -1 || left > right) return 0
        if (left == 0 && right == 0) return 1
        return getValidParenPairsCount(left - 1, right) + getValidParenPairsCount(left, right - 1)
    }
}