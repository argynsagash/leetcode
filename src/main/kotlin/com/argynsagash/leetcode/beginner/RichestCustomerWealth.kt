package com.argynsagash.leetcode.beginner

class RichestCustomerWealth {
    fun maximumWealth(accounts: Array<IntArray>): Int {

        var maxNumber = 0
        accounts.map { account -> if (account.sum() > maxNumber) maxNumber = account.sum()}
        return maxNumber


    }
    //version_2
    fun maximumWealth2(accounts: Array<IntArray>) = accounts.map { it.sum() }.maxOf { it }
}

fun main() {
    val solution = RichestCustomerWealth()

    //version_1
    //same as int[] nums1 = {1, 2, 3};
    val nums1 = intArrayOf(1, 2, 3)
    val nums2 = intArrayOf(3, 2, 1)
    val array1: Array<IntArray> = arrayOf(nums1, nums2)

    //version_2
    //same as int [][] array2 = new int[2][3];
    val array2 = Array(2) { IntArray(3) }
    array2[0][0] = 1
    array2[0][1] = 2
    array2[0][2] = 3

    array2[1][0] = 3
    array2[1][1] = 2
    array2[1][2] = 1

    //same as int[][] array = {{1,2,3},{3,2,1}};
    val array3: Array<IntArray> = arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))
    val array4: Array<IntArray> = arrayOf(intArrayOf(1, 5), intArrayOf(7, 3), intArrayOf(3, 5))
    val array5: Array<IntArray> = arrayOf(
        intArrayOf(2, 8, 7),
        intArrayOf(7, 1, 3),
        intArrayOf(1, 9, 5)
    )
    println(solution.maximumWealth2(array3))
    println()
    println(solution.maximumWealth2(array4))
    println()
    println(solution.maximumWealth2(array5))
}

