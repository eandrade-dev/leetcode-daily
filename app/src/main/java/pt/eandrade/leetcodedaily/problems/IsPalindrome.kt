package pt.eandrade.leetcodedaily.problems

import pt.eandrade.leetcodedaily.misc.IsProblem

class IsPalindrome: IsProblem {
    override fun run() : String {
        val dataSet = when((1..4).random()){
            1 -> {
                "A man, a plan, a canal: Panama"
            }
            2 -> {
                "race a car"
            }
            3 -> {
                " "
            }
            4 -> {
                "0P"
            }
            else -> { "" }
        }

        var resultStr = "DataSet: $dataSet"
        val resultBoolean = solve(dataSet)
        resultStr += "\nResult: $resultBoolean"

        return resultStr
    }

    // Disregard warnings - won't run in leetcode.com with these fixed
    @Suppress("DEPRECATION", "RedundantLambdaArrow")
    private fun solve(s: String): Boolean {
        var input = s.toLowerCase()
        if(s.isBlank()){
            return true
        }

        input = input.filter { it: Char -> it.isLetterOrDigit() }

        val halfLength = input.length / 2
        for(i in 0 until halfLength){
            if(input[i] != input[input.length - 1 - i]){
                return false
            }
        }
        return true
    }
}