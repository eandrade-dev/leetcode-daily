package pt.eandrade.leetcodedaily.problems

import pt.eandrade.leetcodedaily.misc.IsProblem
import java.util.*

class ValidParenthesis : IsProblem {

    override fun run() : String {
        val rng = (1..5).random()

        var dataSet = ""

        when(rng){
            1 -> {
                dataSet = "()"
            }
            2 -> {
                dataSet = "()[]{}"
            }
            3 -> {
                dataSet = "(]"
            }
            4 -> {
                dataSet = "([)]"
            }
            5 -> {
                dataSet = "(([]){})"
            }
        }

        var resultStr = "DataSet: $dataSet"
        val resultBoolean = solve(dataSet)
        resultStr += "\nResult: $resultBoolean"

        return resultStr
    }

    private fun solve(input: String): Boolean {
        val startChars = listOf('(', '[', '{')
        val endChars = listOf(')', ']', '}')
        val stack = Stack<Char>()

        for(p in input){
            if(startChars.contains(p)){
                stack.push(p)
            }
            else if (endChars.contains(p))
            {
                if(stack.size == 0)
                {
                    return false
                }

                val index = endChars.indexOf(p)
                val matching = startChars[index]

                if (stack.peek() != matching)
                {
                    return false
                }
                stack.pop()
            }
            else
            {
                return false
            }
        }

        if(stack.size > 0)
        {
            return false
        }
        return true
    }
}