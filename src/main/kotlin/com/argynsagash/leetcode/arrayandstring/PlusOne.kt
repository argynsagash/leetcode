package com.argynsagash.leetcode.arrayandstring

class PlusOne {

    fun plusOne(digits: IntArray): IntArray {
        val listDigits = mutableListOf<Int>()
        var reminder = 1
        for (digit in digits.reversed()) {
            if (digit.plus(reminder) == 10) {
                reminder = 1
                listDigits.add(0, 0)
            } else {
                listDigits.add(0, digit.plus(reminder))
                reminder = 0
            }
        }
        if (reminder == 1) listDigits.add(0, 1)
        return listDigits.toIntArray()
    }

    //version_2
    fun plusOneV2(digits: IntArray): IntArray {
        for (i in digits.size - 1 downTo 0) {
            digits[i] += 1
            if (digits[i] <= 9) return digits
            digits[i] = 0
        }
        val arr = IntArray(digits.size + 1)
        arr[0] = 1

        return arr
    }

}