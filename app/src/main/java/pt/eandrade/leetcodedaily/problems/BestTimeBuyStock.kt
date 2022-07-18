package pt.eandrade.leetcodedaily.problems

import pt.eandrade.leetcodedaily.misc.IsProblem
import kotlin.math.max

class BestTimeBuyStock: IsProblem {

    override fun run() : String {
        val dataSet = when((1..4).random()){
            1 -> {
                intArrayOf(7, 1, 5, 3, 6, 4)
            }
            2 -> {
                intArrayOf(7, 6, 4, 3, 1)
            }
            3 -> {
                intArrayOf(1, 1, 2, 2, 5, 2, 1)
            }
            4 -> {
                intArrayOf(10, 0, 20, 4, 2, 1)
            }
            else -> { intArrayOf(0) }
        }

        var resultStr = "DataSet: ${dataSet.contentToString()}"
        val resultProfit = solve(dataSet)
        resultStr += "\nMax Profit: $resultProfit"

        return resultStr
    }

    private fun solve(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0

        for(i in prices.indices){
            if(prices[i] < minPrice){
                minPrice = prices[i]
            }
            else{
                maxProfit = max(maxProfit, prices[i] - minPrice)
            }
        }
        return maxProfit
    }
}