package pt.eandrade.leetcodedaily.misc

class Utils {
    companion object{
        fun printTree(root: TreeNode?) : String {
            var treeStr = ""

            if(root == null){
                return treeStr
            }

            treeStr += "${root.`val`}, "
            treeStr += printTree(root.left)
            treeStr += printTree(root.right)

            return treeStr
        }

        class TreeNode(var `val`: Int = 0, var left: TreeNode? = null, var right: TreeNode? = null)

        fun printNode(node: ListNode) : String {
            var nodeStr = ""

            var current: ListNode? = node
            while(current != null){
                nodeStr += "${current.`val`}, "
                current = current.next
            }

            return nodeStr.removeSuffix(", ")
        }

        class ListNode(var `val`: Int, var next: ListNode? = null)
    }
}