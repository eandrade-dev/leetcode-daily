package pt.eandrade.leetcodedaily.problems

import pt.eandrade.leetcodedaily.misc.IsProblem
import pt.eandrade.leetcodedaily.misc.Utils
import pt.eandrade.leetcodedaily.misc.Utils.Companion.ListNode

class LinkedListCycle : IsProblem {
    override fun run() : String {
        val tests = arrayOf(
            // LinkedList, Position
            // 1
            Pair(ListNode(3, ListNode(2, ListNode(0, ListNode(-4)))), 1),
            // 2
            Pair(ListNode(1, ListNode(2)), 0),
            // 3
            Pair(ListNode(1), -1),
            // 4
            Pair(ListNode(1, ListNode(2)), -1),
            // 5
            //[-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5]
            Pair(ListNode(-21, ListNode(10, ListNode(17, ListNode(8, ListNode(4,
            ListNode(26, ListNode(5, ListNode(35, ListNode(33, ListNode(-7,
            ListNode(-16, ListNode(27, ListNode(-12, ListNode(6, ListNode(29,
            ListNode(-12, ListNode(5, ListNode(9, ListNode(20,
            ListNode(14, ListNode(14, ListNode(2, ListNode(13,
            ListNode(-24, ListNode(21, ListNode(23, ListNode(-21,
            ListNode(5)))))))))))))))))))))))))))), -1),
        )

        var resultStr = ""
        for (input in tests){
            resultStr += "DataSet: ${Utils.printNode(input.first)}"
            val result = hasCycle(input.first)
            resultStr += "\nResult: $result"
            resultStr += "\n\n"
        }
        return resultStr

    }

    private fun hasCycle(head: ListNode?): Boolean {
        val set = mutableSetOf<ListNode>()

        var node: ListNode? = head
        while(node != null){
            if(set.contains(node)){
                return true
            }
            set.add(node)
            node = node.next
        }

        return false
    }
}