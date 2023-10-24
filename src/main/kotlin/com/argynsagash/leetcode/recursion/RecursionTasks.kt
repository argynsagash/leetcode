package com.argynsagash.leetcode.recursion

import kotlin.math.max

/**
Задача 1

Дано целое число n. Напишите функцию, которая вычисляет сумму всех его цифр.

Пример
input: 1234
output: 10
 */

//1-описание словами Р.Ф.
//описание - вычисляет сумму всех его цифр
//аргументы - целое число
//возвращаемое значение - сумма всех цифр
fun getDigitsSum(n: Int): Int {
    //2-есть базовый случай
    if (n < 10) return n
    //3-найти аргументы задачи меньшего размера
    val digitsSum: Int = getDigitsSum(n / 10)
    //4-Решить текущую задачу
    val currentDigit = n % 10
    return digitsSum + currentDigit
}


/**
Задача 2

Напишите рекурсивную функцию, которая находит максимальный элемент в массиве.

Пример
input: {1, 4, 22, -1}
output: 22
 */
//1-описание словами Р.Ф.
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
    //4-Решить текущую задачу
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
    //4-Решить текущую задачу
    val currNum = arr[size - 1]
    return max(currNum, maxInArr)
}


/**
Задача 3

На вход функции приходит целое число n. Нужно вывести все его цифры по
одной, в обратном порядке, разделяя их запятыми.

Пример
input: 29641
output: 1, 4, 6, 9, 2
 */
//1-описание словами Р.Ф.
//описание - вывести все цифры через запятую в обратном порядке
//аргументы - целое число
//возвращаемое значение - Строка через запятую
fun getReversedDigits(n: Int): String {
    //2-есть базовый случай
    if (n < 10) return n.toString()
    //3-найти аргументы задачи меньшего размера
    val reversedDigits = getReversedDigits(n / 10)
    //4-Решить текущую задачу
    return (n % 10).toString() + ", " + reversedDigits
}

/**
Задача 4

Напишите функцию, которая решает являться ли слово палиндромом.

Пример
input: abba
output: true
 */
//1-описание словами Р.Ф.
//описание - проверить является ли слово палиндромом
//аргументы - слово
//возвращаемое значение - да/нет
private fun isPalindrome(word: String, left: Int, right: Int): Boolean {
    //2-есть базовый случай
    if (left >= right) return true
    if (word[left] != word[right]) return false
    //3-найти аргументы задачи меньшего размера
    //4-Решить текущую задачу
    return isPalindrome(word, left + 1, right - 1)
}
fun isPalindrome(word: String): Boolean {
    return isPalindrome(word, 0, word.length - 1)
}