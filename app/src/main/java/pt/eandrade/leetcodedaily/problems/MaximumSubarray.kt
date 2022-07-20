package pt.eandrade.leetcodedaily.problems

import pt.eandrade.leetcodedaily.misc.IsProblem
import kotlin.math.max

class MaximumSubarray : IsProblem {
    override fun run() : String {
        val input = when((1..4).random()){
            1 -> {
                intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
            }
            2 -> {
                intArrayOf(1)
            }
            3 -> {
                intArrayOf(5,4,-1,7,8)
            }
            4 -> {
                intArrayOf(-1)
            }
            else -> {
                intArrayOf(-1, 0, 3, 5, 9, 12)
            }
        }

        var resultStr = "DataSet: ${input.contentToString()}"
        val result = maxSubArray(input)
        resultStr += "\nResult: $result"

        return resultStr
    }

    private fun maxSubArray(nums: IntArray): Int {
        if(nums.isEmpty()) return 0

        var currentSum = nums[0]
        var maxSum = nums[0]

        for(i in 1 until nums.size) {
            currentSum = max(nums[i], currentSum + nums[i])
            maxSum = max(maxSum, currentSum)
        }

        return maxSum
    }
}