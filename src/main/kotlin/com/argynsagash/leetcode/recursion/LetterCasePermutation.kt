package com.argynsagash.leetcode.recursion

/**
 * Letter Case Permutation
 *
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 *
 * Return a list of all possible strings we could create. Return the output in any order.
 *
 * Constraints:
 *
 * * 1 <= s.length <= 12
 * * s consists of lowercase English letters, uppercase English letters, and digits.
 */
class LetterCasePermutation {
    fun letterCasePermutation(s: String): List<String> {
        val result = mutableListOf<String>()
        letterCasePermutation("", 0, s, result)
        return result
    }
    //СЛОЖНОСТЬ: O(2N^2 * 2^N)
    private fun letterCasePermutation(word: String, chars: String, result: MutableList<String>) {
        //1-определить все базовые случаи
        if (chars.isEmpty()) {
            println(word)
            return
        }
        //3-посчитать количество стрелок в дереве. Иногда один иногда два.
        //Пишем if/else
        //4-определить задачу меньшего размера
        val c: Char = chars[0]
        val trimmedChars = chars.substring(1)
        if (Character.isDigit(c)) {
            letterCasePermutation(word + c, trimmedChars, result)
        } else {
            letterCasePermutation(word + c.lowercase(), trimmedChars, result)
            letterCasePermutation(word + c.uppercase(), trimmedChars, result)
        }
    }

    //ОПТИМИЗАЦИЯ
    //СЛОЖНОСТЬ: O(N^2 * 2^N)
    //version_2
    private fun letterCasePermutation(word: String, charIndex: Int, chars: String, result: MutableList<String>) {
        //1-определить все базовые случаи
        if (charIndex == chars.length) {
            result.add(word)
            return
        }
        //3-посчитать количество стрелок в дереве. Иногда один иногда два.
        //Пишем if/else
        //4-определить задачу меньшего размера
        val c: Char = chars[charIndex]
        if (Character.isDigit(c)) {
            letterCasePermutation(word + c, charIndex + 1, chars, result)
        } else {
            letterCasePermutation(word + c.lowercase(), charIndex + 1, chars, result)
            letterCasePermutation(word + c.uppercase(), charIndex + 1, chars, result)
        }
    }

}