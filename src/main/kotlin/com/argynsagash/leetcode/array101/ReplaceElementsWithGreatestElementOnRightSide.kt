package com.argynsagash.leetcode.array101

//Easy
class ReplaceElementsWithGreatestElementOnRightSide {

    fun replaceElements(arr: IntArray): IntArray {
        if (arr.isEmpty()) return arr
        if (arr.size == 1) {
            arr[0] = -1
            return arr
        }

        var max = arr[1]
        for (i in arr.indices) {
            for (j in (i + 1) until arr.size) {
                if (arr[j] > max) max = arr[j]
            }
            arr[i] = max
            if ((i + 2) < arr.size) max = arr[i + 2]

        }

        arr[arr.size - 1] = -1
        return arr
    }

    //version_2
    fun replaceElementsV2(arr: IntArray): IntArray {
        if (arr.size == 1) {
            arr[0] = -1
            return arr
        }
        var max = arr[arr.size - 1]
        var temp: Int
        for (i in arr.size - 2 downTo 0) {
            temp = arr[i]
            arr[i] = max
            max = max.coerceAtLeast(temp)
        }
        arr[arr.size - 1] = -1
        return arr
    }

    //version_3
    fun replaceElementsV3(arr: IntArray): IntArray {
        var max = -1
            //17, 18, 5, 4, 6, 1
        for (i in arr.size - 1 downTo 0) {
            val current = arr[i]
            arr[i] = max
            max = maxOf(current, max)
        }

        return arr
    }
}