package com.argynsagash.leetcode.array101

//Easy
class CheckIfNAndItsDoubleExist {

    fun checkIfExist(arr: IntArray): Boolean {
        for (i in arr.indices) {
            for (j in (i + 1) until arr.size) {
                if (arr[i] == 2 * arr[j] || arr[j] == arr[i] * 2) return true
            }
        }
        return false
    }
}