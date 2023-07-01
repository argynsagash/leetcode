package com.argynsagash.leetcode.beginner


class FizzBuzz {

    fun fizzBuzz(n: Int): List<String> {
        val listString = mutableListOf<String>()

        for (num in 1..n) {
            when {
                num % 15 == 0 -> listString.add("FizzBuzz")
                num % 3 == 0 -> listString.add("Fizz")
                num % 5 == 0 -> listString.add("Buzz")
                else -> listString.add("$num")
            }
        }

        return listString
    }

    //version_2
    fun fizzBuzzV2(n: Int) = (1..n).map {
        when {
            it % 15 == 0 -> "FizzBuzz"
            it % 5 == 0 -> "Buzz"
            it % 3 == 0 -> "Fizz"
            else -> it.toString()
        }
    }
}