package com.argynsagash.leetcode

/**
 * [CHECK IF N AND ITS DOUBLE EXIST](https://leetcode.com/problems/check-if-n-and-its-double-exist/)
 *
 * Easy
 *
 * Given an array arr of integers, check if there exist two indices i and j such that :
 *
 *      i != j
 *      0 <= i, j < arr.length
 *      arr [i] == 2 * arr [j]
 *
 * Example 1:
 *
 *      Input: arr = [10,2,5,3]
 *      Output: true
 *      Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
 *
 * Example 2:
 *
 *      Input: arr = [3,1,7,11]
 *      Output: false
 *      Explanation: There is no i and j that satisfy the conditions.
 *
 * Constraints:
 *
 *      2 <= arr.length <= 500
 *      -103 <= arr[i] <= 103
 */
fun checkIfExist(arr: IntArray): Boolean {
    for (i in arr.indices) {
        for (j in (i + 1) until arr.size) {
            if (arr[i] == 2 * arr[j] || arr[j] == arr[i] * 2) return true
        }
    }
    return false
}

/**
 * [DUPLICATE ZEROS](https://leetcode.com/problems/duplicate-zeros/)
 *
 * Easy
 *
 * Given a fixed-length integer array arr, duplicate each occurrence of zero,
 * shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place and do not return anything.
 *
 * Example 1:
 *
 *      Input: arr = [1,0,2,3,0,4,5,0]
 *      Output: [1,0,0,2,3,0,0,4]
 *      Explanation: After calling your function, the input array is modified to:
 *      [1,0,0,2,3,0,0,4]
 *
 * Example 2:
 *
 *      Input: arr = [1,2,3]
 *      Output: [1,2,3]
 *      Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 * Constraints:
 *
 *      1 <= arr.length <= 104
 *      0 <= arr[i] <= 9
 */
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

/**
 * [FIND ALL NUMBERS DISAPPEARED IN AN ARRAY](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
 *
 * Easy
 *
 * Given an array nums of n integers where nums&#91;i&#93; is in the range&#91;1, n&#93;,
 * return an array of all the integers in the range&#91;1, n&#93; that do not appear in nums.
 *
 * Example 1:
 *
 *      Input: nums = [4,3,2,7,8,2,3,1]
 *      Output: [5,6]
 *
 * Example 2:
 *
 *      Input: nums = [1,1]
 *      Output: [2]
 *
 * Constraints:
 *
 *      n == nums.length
 *      1 <= n <= 105
 *      1 <= nums[i] <= n
 *
 * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val list = (1..nums.size).toMutableList()
    for (n in nums.distinct()) list.remove(n)
    return list
}

/**
 * [FIND NUMBERS WITH EVEN NUMBERS OF DIGITS](https://leetcode.com/problems/find-numbers-with-even-number-of-digits/)
 *
 * Easy
 *
 * Given an array nums of integers, return how many of them contain an even number of digits.
 *
 * Example 1:
 *
 *      Input: nums = [12,345,2,6,7896]
 *      Output: 2
 *      Explanation:
 *      12 contains 2 digits (even number of digits).
 *      345 contains 3 digits (odd number of digits).
 *      2 contains 1 digit (odd number of digits).
 *      6 contains 1 digit (odd number of digits).
 *      7896 contains 4 digits (even number of digits).
 *      Therefore only 12 and 7896 contain an even number of digits.
 *
 * Example 2:
 *
 *      Input: nums = [555,901,482,1771]
 *      Output: 1
 *      Explanation:
 *      Only 1771 contains an even number of digits.
 *
 * Constraints:
 *
 *      1 <= nums.length <= 500
 *      1 <= nums[i] <= 105
 */
fun findNumbers(nums: IntArray): Int {
    var counter = 0
    for (n in nums) {
        if (n.toString().length % 2 == 0) counter++
    }
    return counter
}

//version_2
fun findNumbersV2(nums: IntArray): Int = nums.filter { it.toString().length % 2 == 0 }.size

//version_3
fun findNumbersV3(nums: IntArray) = nums.count { it.toString().length % 2 == 0 }

/**
 * [HEIGHT CHECKER](https://leetcode.com/problems/height-checker/)
 *
 * Easy
 *
 * A school is trying to take an annual photo of all the students.
 * The students are asked to stand in a single file line in non-decreasing order by height.
 * Let this ordering be represented by the integer array expected where expected&#91;i&#93;
 * is the expected height of the ith student in line.
 *
 * You are given an integer array heights representing the current order that the students are
 * standing in. Each heights&#91;i&#93; is the height of the ith student in line (0-indexed).
 *
 * Return the number of indices where heights&#91;i&#93; != expected&#91;i&#93;.
 *
 * Example 1:
 *
 *      Input: heights = [1,1,4,2,1,3]
 *      Output: 3
 *      Explanation: heights:  [1,1,4,2,1,3] expected: [1,1,1,2,3,4]
 *      Indices 2, 4, and 5 do not match.
 *
 * Example 2:
 *
 *      Input: heights = [5,1,2,3,4]
 *      Output: 5
 *      Explanation: heights:  [5,1,2,3,4] expected: [1,2,3,4,5]
 *      All indices do not match.
 *
 * Example 3:
 *
 *      Input: heights = [1,2,3,4,5]
 *      Output: 0
 *      Explanation: heights:  [1,2,3,4,5] expected: [1,2,3,4,5]
 *      All indices match.
 *
 * Constraints:
 *
 *      1 <= heights.length <= 100
 *      1 <= heights[i] <= 100
 */
fun heightChecker(heights: IntArray) = heights.sorted().filterIndexed { i, n -> n != heights[i] }.size