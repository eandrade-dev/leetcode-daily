package pt.eandrade.leetcodedaily.problems

import pt.eandrade.leetcodedaily.misc.IsProblem

class MergeTwoLists : IsProblem {

    override fun run(): String {
        val rng = (1..2).random()

        lateinit var listNode1: ListNode
        lateinit var listNode2: ListNode

        when (rng) {
            1 -> {
                listNode1 = ListNode(1, ListNode(3))
                listNode2 = ListNode(2, ListNode(4))
            }
            2 -> {
                listNode1 = ListNode(1, ListNode(2, ListNode(4)))
                listNode2 = ListNode(1, ListNode(3, ListNode(4)))
            }
        }

        var node1: ListNode? = listNode1
        var node2: ListNode? = listNode2
        var resultStr = "DataSet:\nList1:"
        while(node1 != null){
            resultStr += "${node1.`val`}, "
            node1 = node1.next
        }
        resultStr += "\nList2:"
        while(node2 != null){
            resultStr += "${node2.`val`}, "
            node2 = node2.next
        }

        var resultNode = solve(listNode1, listNode2)

        resultStr += "\nResult:"
        while(resultNode != null){
            resultStr += "${resultNode.`val`}, "
            resultNode = resultNode.next
        }

        return resultStr
    }

    private fun solve(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1: ListNode? = list1
        var l2: ListNode? = list2
        val head = ListNode(0)
        var current = head

        while(l1 != null && l2 != null){
            if(l1.`val` <= l2.`val`){
                current.next = l1
                l1 = l1.next
            }else{
                current.next = l2
                l2 = l2.next
            }
            current = current.next!!
        }
        if(l1 != null)
        {
            current.next = l1
        }
        else
        {
            current.next = l2
        }

        return head.next
    }

    class ListNode(var `val`: Int = 0, var next: ListNode? = null)
}