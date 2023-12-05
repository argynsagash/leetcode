package com.argynsagash.leetcode.recursion

import java.lang.StringBuilder
import kotlin.math.abs
import kotlin.math.max
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

/**
 * Задача 1
 *
 * Дано целое число n. Напишите функцию, которая вычисляет сумму всех его цифр.
 *
 * Пример
 * input: 1234
 * output: 10
 */
//1-описание
//описание - вычисляет сумму всех его цифр
//аргументы - целое число
//возвращаемое значение - сумма всех цифр
fun getDigitsSum(n: Int): Int {
    //2-есть базовый случай
    if (n < 10) return n
    //3-найти аргументы задачи меньшего размера
    val digitsSum: Int = getDigitsSum(n / 10)
    //4-решить текущую задачу
    val currentDigit = n % 10
    return digitsSum + currentDigit
}

/**
 * Задача 2
 *
 * Напишите рекурсивную функцию, которая находит максимальный элемент в массиве.
 *
 * Пример
 * input: {1, 4, 22, -1}
 * output: 22
 */
//1-описание
//описание - возвращает максимальный элемент
//аргументы - массив чисел
//возвращаемое значение - максимальное число
fun getMax(arr: Array<Int>): Int {
    //2-есть базовый случай
    if (arr.size == 1) return arr[0]
    //3-найти аргументы задачи меньшего размера
    //Если это LinkedList/ArrayList можно удалять элементы, но тогда мы портим массив, так как мы ссылаемся на оригинальный
    //список, поэтому так делать категорически нельзя,
    //можно создать копию, но это долго. Лучший вариант смотри версию_2
    val maxInArr = getMax(arr.copyOfRange(0, arr.size - 1))
    //4-решить текущую задачу
    val currNum = arr[arr.size - 1]
    return max(currNum, maxInArr)
}

//version_2
fun getMaxV2(arr: Array<Int>, size: Int): Int {
    //2-есть базовый случай
    if (size == 1) return arr[0]
    //3-найти аргументы задачи меньшего размера
    //Если это LinkedList/ArrayList можно удалять элементы, но тогда мы портим массив, так как мы ссылаемся на оригинальный
    //список, поэтому так делать категорически нельзя,
    //можно создать копию, но это долго. Лучший вариант смотри версию_2
    val maxInArr = getMaxV2(arr, size - 1)
    //4-решить текущую задачу
    val currNum = arr[size - 1]
    return max(currNum, maxInArr)
}

/**
 * Задача 3
 *
 * На вход функции приходит целое число n. Нужно вывести все его цифры по
 * одной, в обратном порядке, разделяя их запятыми.
 *
 * Пример
 * input: 29641
 * output: 1, 4, 6, 9, 2
 */
//1-описание
//описание - вывести все цифры через запятую в обратном порядке
//аргументы - целое число
//возвращаемое значение - Строка через запятую
fun getReversedDigits(n: Int): String {
    //2-есть базовый случай
    if (n < 10) return n.toString()
    //3-найти аргументы задачи меньшего размера
    val reversedDigits = getReversedDigits(n / 10)
    //4-решить текущую задачу
    return (n % 10).toString() + ", " + reversedDigits
}

/**
 * Задача 4
 *
 * Напишите функцию, которая решает являться ли слово палиндромом.
 *
 * Пример
 * input: abba
 * output: true
 */
//1-описание
//описание - проверить является ли слово палиндромом
//аргументы - слово
//возвращаемое значение - да/нет
private fun isPalindrome(word: String, left: Int, right: Int): Boolean {
    //2-есть базовый случай
    if (left >= right) return true
    if (word[left] != word[right]) return false
    //3-найти аргументы задачи меньшего размера
    //4-решить текущую задачу
    return isPalindrome(word, left + 1, right - 1)
}

fun isPalindrome(word: String): Boolean {
    return isPalindrome(word, 0, word.length - 1)
}

//ТУТ ЗАДАЧИ ПОИСК С ВОЗВРАТОМ - ИСПОЛЬЗУЙ ДЕРЕВО
/**
 * Задача 5
 *
 * Лягушка сидит на ступеньке N и может прыгать вниз на 1 или 2 ступеньки.
 * Напечатайте все варианты прыгнуть со ступеньки N до пола
 *
 * Пример
 * input: 3
 * output: "111", "12", "21"
 */
//1-описание
//описание - напечатать все варианты прыжков лягушки до пола
//аргументы - количество ступенек
//возвращаемое значение - варианты прыжков
//СЛОЖНОСТЬ: O(N^2 * 2^N)
private fun printPaths(pathCandidate: String, step: Int) {
    //1-определить все базовые случаи
    if (step == -1) return
    if (step == 0) {
        println(pathCandidate)
        return
    }
    //3-посчитать количество стрелок в дереве
    //4-определить задачу меньшего размера
    printPaths(pathCandidate + "1", step - 1)
    printPaths(pathCandidate + "2", step - 2)
}

fun printPaths(step: Int) {
    printPaths("", step)
}

/**
 * Задача 6
 *
 * Напечатайте все верные, уникальные комбинации из пар круглых скобок
 *
 * Пример
 * input: 2
 * output: "(())", "()()"
 */
//1-описание
//описание - напечатать все варианты пар круглых скобок
//аргументы - количество скобок
//возвращаемое значение - варианты пар
//СЛОЖНОСТЬ: O(N^2 * 2^N)
private fun printParenthesis(parenCandidate: String, left: Int, right: Int) {
    //1-определить все базовые случаи
    if (left == -1 || left > right) return
    if (left == 0 && right == 0) {
        println(parenCandidate)
        return
    }
    //3-посчитать количество стрелок в дереве
    //4-определить задачу меньшего размера
    printParenthesis(parenCandidate + "(", left - 1, right)
    printParenthesis(parenCandidate + ")", left, right - 1)
}

fun printParenthesis(parenthesisCount: Int) {
    printParenthesis("", parenthesisCount, parenthesisCount)
}

/**
 * Задача 7
 *
 * Дана строка состоящая из цифр и букв в верхнем и/или нижнем регистре.
 * Напечатайте строки состоящие из всех вариантов регистров букв.
 *
 * Пример
 * input: a1B2
 * output: "a1b2", "a1B2", "A1b2", "A1B2"
 */
//1-описание
//описание - напечатать строки состоящие из всех вариантов регистров букв
//аргументы - строка из цифр и букв
//возвращаемое значение - варианты регистров букв
//СЛОЖНОСТЬ: O(N^2 * 2^N)
private fun printTransforms(word: String, chars: String) {
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
        printTransforms(word + c, trimmedChars)
    } else {
        printTransforms(word + c.lowercase(), trimmedChars)
        printTransforms(word + c.uppercase(), trimmedChars)
    }
}

fun printTransforms(word: String) {
    printTransforms("", word)
}

/**
 * Задача 8
 *
 * Напишите функцию для замены всех пробелов в строке на 20%.
 * На вход функции передается два параметра:
 * * Строка содержащая достаточно места для хранения всех %20
 * * Реальная длина строки, будто в ней не выделено место для %20
 *
 * Пример
 * input: "dog is a good boy", 17
 * output: "dog%20is%20a%20good%20boy"
 */
//1-описание
//описание - функция которая заменяет пробелы
//аргументы - строка и количество допустимых %20
//возвращаемое значение - строка с замененными пробелами
//СЛОЖНОСТЬ:
private fun replaceSpaces(word: String, size: Int) {
    //1-определить все базовые случаи
//    if (left == -1 || left > right) return
//    if (left == 0 && right == 0) {
//        println(parenCandidate)
//        return
//    }
    //3-посчитать количество стрелок в дереве
    //4-определить задачу меньшего размера
}

/**
 * Задача 9
 *
 * Напишите функцию, которая копирует все символы из строки в массив
 *
 * Пример
 * input: "ABC"
 * output: ["A","B","C"]
 */
//1-описание
//описание - копировать символы из строки в массив
//аргументы - строка
//возвращаемое значение - массив
//СЛОЖНОСТЬ:
fun moveStrToArr(letters: MutableList<Char>, str: String) {
    //1-определить все базовые случаи
    if (str.isEmpty()) return
    //3-посчитать количество стрелок в дереве
    //4-определить задачу меньшего размера
    val letter: Char = str[0]
    letters.add(letter)
    val trimmedStr = str.substring(1)
    moveStrToArr(letters, trimmedStr)
}

//ОПТИМИЗАЦИЯ КОДА
fun moveStrToArr(letters: MutableList<Char>, startIndex: Int, str: String) {
    //1-определить все базовые случаи
    if (startIndex == str.length) return
    //3-посчитать количество стрелок в дереве
    //4-определить задачу меньшего размера
    val letter: Char = str[startIndex]
    letters.add(letter)
    moveStrToArr(letters, startIndex + 1, str)
}

/**
 * Задача 10
 *
 * Напишите функцию, поиска всех двоичных чисел длиной 3 бита
 *
 * Пример
 * input:
 * output:
 */
//1-описание
//описание - копировать символы из строки в массив
//аргументы - строка
//возвращаемое значение - массив
//СЛОЖНОСТЬ: O(N^2 * 2^N)
fun printBin(size: Int) {
    printBin("", size)
}

private fun printBin(bin: String, size: Int) {
    //1-определить все базовые случаи
    if (bin.length == size) {
        println(bin)
        return
    }
    //3-посчитать количество стрелок в дереве
    //4-определить задачу меньшего размера
    printBin(bin + "0", size)
    printBin(bin + "1", size)
}

//ЧТО НА САМОМ ДЕЛЕ ПРОИСХОДИТ СО STRING-ом
fun printBin(bin: MutableList<Char>, size: Int) {
    //1-определить все базовые случаи
    if (bin.size == size) {
        println(bin)
        return
    }
    //3-посчитать количество стрелок в дереве
    //4-определить задачу меньшего размера
    var binCopy: MutableList<Char> = bin.toMutableList()
    binCopy.add('0')
    printBin(binCopy, size)

    binCopy = bin.toMutableList()
    binCopy.add('1')
    printBin(binCopy, size)
}

//ОПТИМИЗАЦИЯ КОДА
//version_2
fun printBinV2(bin: MutableList<Char>, size: Int) {
    //1-определить все базовые случаи
    if (bin.size == size) {
        println(bin)
        return
    }
    //3-посчитать количество стрелок в дереве
    //4-определить задачу меньшего размера
    bin.add('0')
    printBin(bin, size)
    //bin.removeAt(bin.size - 1)
    bin.removeLast()

    //сразу же после завершения рекурсии удаляем добавленный элемент
    //это позволит отказаться от копии массива
    bin.add('1')
    printBin(bin, size)
    bin.removeLast()

}

/**
 * [MAXIMUM PRODUCT OF THE LENGTH OF TWO PALINDROMIC SUBSEQUENCES](https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/)
 *
 * Given a string s, find two disjoint palindromic subsequences of s such that the product of their lengths is maximized. The two subsequences are disjoint if they do not both pick a character at the same index.
 *
 * Return the maximum possible product of the lengths of the two palindromic subsequences.
 *
 * A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters. A string is palindromic if it reads the same forward and backward.
 *
 * Example 1
 * * Input: s = "leetcodecom"
 *
 * * Output: 9
 *
 * * Explanation: An optimal solution is to choose "ete" for the 1st subsequence and "cdc" for the 2nd subsequence.
 * The product of their lengths is: 3 * 3 = 9.
 *
 * Example 2:
 *
 * * Input: s = "bb"
 * * Output: 1
 * * Explanation: An optimal solution is to choose "b" (the first character) for the 1st subsequence and "b" (the second character) for the 2nd subsequence.
 * The product of their lengths is: 1 * 1 = 1.
 *
 * Example 3:
 *
 * * Input: s = "accbcaxxcxx"
 * * Output: 25
 * * Explanation: An optimal solution is to choose "accca" for the 1st subsequence and "xxcxx" for the 2nd subsequence.
 * The product of their lengths is: 5 * 5 = 25.
 *
 * Constraints:
 *
 * * 2 <= s.length <= 12
 * * s consists of lowercase English letters only.
 */
//СЛОЖНОСТЬ: O(3^N)
fun maxProduct(s: String): Int {
    val palindromeMaxProduct = intArrayOf(0)
    maxProduct("", "", 0, s, palindromeMaxProduct)
    return palindromeMaxProduct[0]
}

private fun maxProduct(cand1: String, cand2: String, startIndex: Int, str: String, palindromeMaxProduct: IntArray) {
    if (startIndex == str.length) {
        if (isPalindrome(cand1) && isPalindrome(cand2))
            palindromeMaxProduct[0] = palindromeMaxProduct[0].coerceAtLeast(cand1.length * cand2.length)
        return
    }
    val letter = str[startIndex]
    maxProduct(cand1 + letter, cand2, startIndex + 1, str, palindromeMaxProduct)
    maxProduct(cand1, cand2 + letter, startIndex + 1, str, palindromeMaxProduct)
    maxProduct(cand1, cand2, startIndex + 1, str, palindromeMaxProduct)
}

private fun isPalindromeV2(word: String): Boolean {
    var start = 0
    var end = word.length - 1;
    while (start < end) {
        if (word[start] != word[end]) return false
        start += 1
        end -= 1
    }
    return true
}

/**
 * [CLOSEST DESSERT COST](https://leetcode.com/problems/closest-dessert-cost/)
 *
 * Medium
 *
 * You would like to make dessert and are preparing to buy the ingredients. You have n ice cream base flavors and m types of toppings to choose from. You must follow these rules when making your dessert:
 *
 * There must be exactly one ice cream base.
 * You can add one or more types of topping or have no toppings at all.
 * There are at most two of each type of topping.
 * You are given three inputs:
 *
 * baseCosts, an integer array of length n, where each baseCosts|i| represents the price of the ith ice cream base flavor.
 * toppingCosts, an integer array of length m, where each toppingCosts|i| is the price of one of the ith topping.
 * target, an integer representing your target price for dessert.
 * You want to make a dessert with a total cost as close to target as possible.
 *
 * Return the closest possible cost of the dessert to target. If there are multiple, return the lower one.
 *
 * Example 1:
 * * Input: baseCosts = [1,7], toppingCosts = [3,4], target = 10
 * * Output: 10
 * * Explanation: Consider the following combination (all 0-indexed):
 * - Choose base 1: cost 7
 * - Take 1 of topping 0: cost 1 x 3 = 3
 * - Take 0 of topping 1: cost 0 x 4 = 0
 * Total: 7 + 3 + 0 = 10.
 *
 * Example 2:
 * * Input: baseCosts = [2,3], toppingCosts = [4,5,100], target = 18
 * * Output: 17
 * * Explanation: Consider the following combination (all 0-indexed):
 * - Choose base 1: cost 3
 * - Take 1 of topping 0: cost 1 x 4 = 4
 * - Take 2 of topping 1: cost 2 x 5 = 10
 * - Take 0 of topping 2: cost 0 x 100 = 0
 * Total: 3 + 4 + 10 + 0 = 17. You cannot make a dessert with a total cost of 18.
 *
 * Example 3:
 * * Input: baseCosts = [3,10], toppingCosts = [2,5], target = 9
 * * Output: 8
 * * Explanation: It is possible to make desserts with cost 8 and 10. Return 8 as it is the lower cost.
 *
 * Constraints:
 * * n == baseCosts.length
 * * m == toppingCosts.length
 * * 1 <= n, m <= 10
 * * 1 <= baseCosts|i|, toppingCosts|i| <= 104
 * * 1 <= target <= 104
 */
//СЛОЖНОСТЬ: O(N*3^N)
fun closestCost(baseCosts: IntArray, toppingCosts: IntArray, target: Int): Int {
    val closestPrice = intArrayOf(baseCosts[0])
    for (cost in baseCosts) getClosestPrice(cost, 0, closestPrice, toppingCosts, target)
    return closestPrice[0]
}

private fun getClosestPrice(desertPrice: Int, closestPrice: Int, targetPrice: Int): Int {
    val currPriceDiff = abs(desertPrice - targetPrice)
    val closestPriceDiff = abs(closestPrice - targetPrice)
    if (currPriceDiff < closestPriceDiff || (currPriceDiff == closestPriceDiff && desertPrice < closestPrice))
        return desertPrice
    return closestPrice
}

private fun getClosestPrice(desertPrice: Int, startIndex: Int, closestPrice: IntArray, toppingCost: IntArray, targetPrice: Int) {
    closestPrice[0] = getClosestPrice(desertPrice, closestPrice[0], targetPrice)
    if (desertPrice > targetPrice || startIndex == toppingCost.size) return
    getClosestPrice(desertPrice + 0 * toppingCost[startIndex], startIndex + 1, closestPrice, toppingCost, targetPrice)
    getClosestPrice(desertPrice + 1 * toppingCost[startIndex], startIndex + 1, closestPrice, toppingCost, targetPrice)
    getClosestPrice(desertPrice + 2 * toppingCost[startIndex], startIndex + 1, closestPrice, toppingCost, targetPrice)
}

/**
 * [LETTER COMBINATIONS OF A PHONE NUMBER](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
 *
 * Medium
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example 1:
 *
 * * Input: digits = "23"
 * * Output: | "ad","ae","af","bd","be","bf","cd","ce","cf" |
 *
 * Example 2:
 *
 * * Input: digits = ""
 * * Output: | |
 *
 * Example 3:
 *
 * * Input: digits = "2"
 * * Output: |"a","b","c"|
 *
 * Constraints:
 *
 * * 0 <= digits.length <= 4
 * * digits |i| is a digit in the range |'2', '9'|.
 */
//СЛОЖНОСТЬ: O(N^2*4^N)
fun letterCombinations(digits: String): List<String> {
    val words = mutableListOf<String>()
    if (digits.isEmpty()) return words
    getWords("", 0, createChars(digits), words)
    return words
}

fun createChars(digits: String): Array<String> {
    val keyboard = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
    val chars = Array(digits.length) { "" }
    for (i in digits.indices) {
        //Самый быстрый способ привести строку в цифру
        //Для символа '2' в Unicode его код равен 50
        //Для символа '0' в Unicode его код равен 48
        //На выходе получаем цифру 50-48 = 2
        val digit: Int = digits[i] - '0'
        chars[i] = keyboard[digit]
    }
    return chars
}

fun getWords(word: String, wordIndex: Int, chars: Array<String>, words: MutableList<String>) {
    if (wordIndex == chars.size) {
        words.add(word);
        return
    }
    for (i in chars[wordIndex].indices) {
        val letter = chars[wordIndex][i]
        getWords(word + letter, wordIndex + 1, chars, words)
    }
}

//ОПТИМИЗАЦИЯ
//СЛОЖНОСТЬ: O(4^N)
fun letterCombinationsV2(digits: String): List<String> {
    val words = mutableListOf<String>()
    if (digits.isEmpty()) return words
    val keyboard = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
    getWords(StringBuilder(digits.length), 0, digits, keyboard, words)
    return words
}

fun getWords(word: StringBuilder, digitIndex: Int, digits: String, keyboard: Array<String>, words: MutableList<String>) {
    if (digitIndex == digits.length) {
        words.add(word.toString());
        return
    }
    val digit = Character.getNumericValue(digits[digitIndex])
    val letters = keyboard[digit]

    for (i in letters.indices) {
        val letter = letters[i]
        word.append(letter)
        getWords(word, digitIndex + 1, digits, keyboard, words)
        word.deleteCharAt(word.length - 1)
    }
}



