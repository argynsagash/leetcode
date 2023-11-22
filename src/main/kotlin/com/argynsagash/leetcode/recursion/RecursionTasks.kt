package com.argynsagash.leetcode.recursion

import kotlin.math.max

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
var palindromeMaxProduct = 0
fun maxProduct(s: String): Int {
    palindromeMaxProduct = 0
    maxProduct("", "", 0, s)
    return palindromeMaxProduct
}

private fun maxProduct(cand1: String, cand2: String, startIndex: Int, str: String) {
    if (startIndex == str.length) {
        if (isPalindrome(cand1) && isPalindrome(cand2))
            palindromeMaxProduct = Math.max(palindromeMaxProduct, cand1.length * cand2.length)
        return
    }
    val letter = str[startIndex]
    maxProduct(cand1 + letter, cand2, startIndex + 1, str)
    maxProduct(cand1, cand2 + letter, startIndex + 1, str)
    maxProduct(cand1, cand2, startIndex + 1, str)
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

