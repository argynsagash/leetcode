package com.argynsagash.leetcode.arrayandstring

import java.util.LinkedList
import java.util.Queue

//Medium
class DiagonalTraverse {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        var givenArray: Array<IntArray> =
                arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9), intArrayOf(10, 11, 12))
        val map: MutableMap<Int, Queue<Int>> = mutableMapOf()
        var q: Queue<Int> = LinkedList()
        for ((i, arr) in givenArray.withIndex()) {
            arr.forEach { q.add(it) }
            map[i] = q
            q = LinkedList()
        }
        println(map.size)
        println(map.values)
        map[1]?.poll()
        println(map.values)

        println(givenArray.size)

        val direction: Boolean
        val list = mutableListOf<Int>()
        map.forEach { k, v ->

            print(k)
            println(v)
            //goUp
            //goDown

        }

        return intArrayOf(0)
    }
}