package com.argynsagash.leetcode.beginner

//Easy
class NumberOfStepsToReduceANumberToZero {

    fun numberOfSteps(num: Int): Int {
        var step = 0
        var number = num
        while (number != 0) {
            if (number % 2 == 0) {
                number /= 2
                step += 1
            } else {
                number -= 1
                step += 1
            }
        }

        return step
    }
}
