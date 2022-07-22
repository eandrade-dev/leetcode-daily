package pt.eandrade.leetcodedaily.problems

import pt.eandrade.leetcodedaily.misc.IsProblem
import pt.eandrade.leetcodedaily.misc.Utils.Companion.TreeNode
import pt.eandrade.leetcodedaily.misc.Utils.Companion.printTree
import kotlin.math.abs
import kotlin.math.max

class BalancedBinaryTree : IsProblem {
    override fun run() : String {
        val tests = arrayOf(
            // 1
            TreeNode(3, TreeNode(9, null, null),
                TreeNode(20, TreeNode(15), TreeNode(7))),
            // 2
            TreeNode(1, TreeNode(2, TreeNode(3, TreeNode(4), TreeNode(4)),
                TreeNode(3)),
                TreeNode(2))
        )

        var resultStr = ""
        for (input in tests){
            resultStr += "DataSet: ${printTree(input)}"
            val result = isBalanced(input)
            resultStr += "\nResult: $result"
            resultStr += "\n\n"
        }
        return resultStr

    }

    private fun isBalanced(root: TreeNode?): Boolean {
        return calcHeight(root) != -1
    }

    private fun calcHeight(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }

        val leftHeight = calcHeight(node.left)
        if(leftHeight == -1) return -1

        val rightHeight = calcHeight(node.right)
        if(rightHeight == -1) return -1

        if(abs(leftHeight - rightHeight) > 1){
            return -1
        }

        return max(leftHeight, rightHeight) + 1
    }
}