package pt.eandrade.leetcodedaily.problems

import pt.eandrade.leetcodedaily.misc.IsProblem

class BinarySearch : IsProblem {
    override fun run() : String {
        val input: IntArray
        val target: Int

        when((1..3).random()){
            1 -> {
                input = intArrayOf(-1, 0, 3, 5, 9, 12)
                target = 9
            }
            2 -> {
                input = intArrayOf(-1, 0, 3, 5, 9, 12)
                target = 2
            }
            3 -> {
                input = intArrayOf(-1, 0, 3, 5, 9, 12)
                target = 13
            }
            else -> {
                input = intArrayOf(-1, 0, 3, 5, 9, 12)
                target = 9
            }
        }

        var resultStr = "DataSet: ${input.contentToString()}"
        resultStr += "\nTarget: $target"
        val result = search(input, target)
        resultStr += "\nResult: $result"

        return resultStr
    }

    private fun search(nums: IntArray, target: Int): Int {
        // 525ms, 67.3 MB
        //return nums.indexOf(target)

        // 484ms, 64.9 MB
        var low = 0
        var high = nums.size-1

        while(low <= high){
            val mid = ((high - low) / 2) + low
            if(nums[mid] == target) return mid else{
                if(nums[mid] > target) {
                    high = mid - 1
                }else{
                    low = mid + 1
                }
            }
        }
        return -1
    }
}