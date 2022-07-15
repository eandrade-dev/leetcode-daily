package pt.eandrade.leetcodedaily.problems

import pt.eandrade.leetcodedaily.misc.IsProblem

class InvertBinaryTree : IsProblem {
    override fun run(): String {
        val dataSet = when ((1..2).random()) {
            1 -> {
                TreeNode(4,
                    TreeNode(2, TreeNode(1), TreeNode(3)),
                    TreeNode(7, TreeNode(6), TreeNode(9))
                )
            }
            2 -> {
                TreeNode(2, TreeNode(1), TreeNode(3))
            }
            else -> {
                TreeNode(1)
            }
        }

        var resultStr = "DataSet:\n"
        resultStr += printTree(dataSet)

        val resultNode = invertTree(dataSet)
        resultStr += "\nResult:\n"
        resultStr += printTree(resultNode)

        return resultStr
    }

    private fun invertTree(root: TreeNode?): TreeNode? {
        if(root == null) { return null }

        val left = root.left
        root.left = invertTree(root.right)
        root.right = invertTree(left)

        return root
    }

    private fun printTree(root: TreeNode?) : String {
        var treeStr = ""

        if(root == null){
            return treeStr
        }

        treeStr += "${root.`val`}, "
        treeStr += printTree(root.left)
        treeStr += printTree(root.right)

        return treeStr
    }

    class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)
}