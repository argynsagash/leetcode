package com.argynsagash.leetcode.array101

class DuplicateZeros {

    fun duplicateZeros(arr: IntArray): Unit {
        val copyArray = arr.copyOf()

        var i = 0
        var c = 0
        while (i < arr.size) {
            if (copyArray[c] == 0 && (i + 1) < arr.size) {
                arr[i] = 0
                i++
                arr[i] = 0
            } else arr[i] = copyArray[c]
            i++
            c++
        }

    }
}