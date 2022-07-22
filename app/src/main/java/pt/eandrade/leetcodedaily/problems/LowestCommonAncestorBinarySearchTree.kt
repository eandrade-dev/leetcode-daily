package pt.eandrade.leetcodedaily.problems

import pt.eandrade.leetcodedaily.misc.IsProblem
import pt.eandrade.leetcodedaily.misc.Utils.Companion.TreeNode
import pt.eandrade.leetcodedaily.misc.Utils.Companion.printTree

class LowestCommonAncestorBinarySearchTree : IsProblem {
    override fun run() : String {
        val root: TreeNode
        val p: TreeNode
        val q: TreeNode

        when((1..3).random()){
            1 -> {
                root = TreeNode(6,
                    TreeNode(2, TreeNode(0), TreeNode(4, TreeNode(3), TreeNode(5))),
                    TreeNode(8, TreeNode(7), TreeNode(9)))
                p = TreeNode(2)
                q = TreeNode(8)
            }
            2 -> {
                root = TreeNode(6,
                    TreeNode(2, TreeNode(0), TreeNode(4, TreeNode(3), TreeNode(5))),
                    TreeNode(8, TreeNode(7), TreeNode(9)))
                p = TreeNode(2)
                q = TreeNode(4)
            }
            3 -> {
                root = TreeNode(2, TreeNode(1))
                p = TreeNode(2)
                q = TreeNode(1)
            }
            else -> {
                root = TreeNode(2, TreeNode(1), null)
                p = TreeNode(2)
                q = TreeNode(1)
            }
        }

        var resultStr = "Tree: ${printTree(root)}"
        resultStr += "\np: ${p.`val`}, q: ${q.`val`}"
        val result = lowestCommonAncestor(root, p, q)
        resultStr += "\nResult: ${result?.`val`}"

        return resultStr
    }

    private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(root == null){
            return null
        }

        val pval = p?.`val` ?: Int.MAX_VALUE
        val qval = q?.`val` ?: Int.MAX_VALUE

        if(pval > qval) {
            return lowestCommonAncestor(root, q, p)
        }
        if(root.`val` in pval..qval){
            return root
        }

        return if(root.`val` < pval && root.`val` < qval){
            lowestCommonAncestor(root.right, p, q)
        } else{
            lowestCommonAncestor(root.left, p, q)
        }
    }

}