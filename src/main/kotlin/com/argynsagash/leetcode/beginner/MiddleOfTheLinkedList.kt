package com.argynsagash.leetcode.beginner

class MiddleOfTheLinkedList {

    fun middleNode(head: ListNode?): ListNode? {

        var listSize = 1
        var headList = head

        while (headList?.next != null) {
            listSize += 1
            headList = headList.next
        }
        var startNumber = listSize / 2 + 1

        headList = head
        listSize = 1

        while (headList?.next != null) {
            if (startNumber == listSize) {
                return headList
            }
            listSize += 1
            headList = headList.next
        }
        return headList
    }

    //version_2
    fun middleNodeV2(head: ListNode?): ListNode? {
        var fast = head
        var slow = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }
}

class ListNode(var n: Int) {
    var next: ListNode? = null
}

