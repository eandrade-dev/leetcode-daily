package pt.eandrade.leetcodedaily.problems

import pt.eandrade.leetcodedaily.misc.IsProblem

class TwoSum : IsProblem {
    override fun run() : String {
        val rng = (1..3).random()

        var dataSet = intArrayOf()
        var target = 0

        when(rng){
            1 -> {
                dataSet = intArrayOf(2, 7, 11, 15)
                target = 9
            }
            2 -> {
                dataSet = intArrayOf(3, 2, 4)
                target = 6
            }
            3 -> {
                dataSet = intArrayOf(3, 3)
                target = 6
            }
        }

        var resultStr = "DataSet: ${dataSet.contentToString()}"
        resultStr += "\nTarget: $target"

        val resultArray = solve(dataSet, target)

        resultStr += "\nResult: ["
        if(resultArray.contentEquals(intArrayOf())){
            resultStr += "Impossible]"
            return resultStr
        }

        for(i in resultArray){
            resultStr += "${i},"
        }
        resultStr = resultStr.trimEnd(',') + "]\n"

        return resultStr
    }

    private fun solve(nums: IntArray, target: Int): IntArray {
        var result = intArrayOf()
        val search = mutableMapOf<Int, Int>()

        for(i in nums.indices){
            if(search.containsKey(target-nums[i])){
                result = intArrayOf(search[target - nums[i]]!!, i)
            }
            search[nums[i]] = i
        }

        return result
    }
}