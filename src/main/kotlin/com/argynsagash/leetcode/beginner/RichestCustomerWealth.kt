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


