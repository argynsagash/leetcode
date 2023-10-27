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
