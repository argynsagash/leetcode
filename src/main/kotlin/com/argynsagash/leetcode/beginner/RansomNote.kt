package com.argynsagash.leetcode.beginner

class RansomNote {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val magazineList = magazine.toMutableList()
        for (letter in ransomNote) {
            if (!magazineList.contains(letter)) return false
            magazineList.remove(letter)
        }
        return true
    }

    //version_2
    fun canConstructV2(ransomNote: String, magazine: String): Boolean {
        val magazineList = magazine.toMutableList()
        for (char in ransomNote) {
            if (!magazineList.remove(char)) return false
        }
        return true
    }
}