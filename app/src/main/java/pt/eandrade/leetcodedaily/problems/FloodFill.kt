package pt.eandrade.leetcodedaily.problems

import pt.eandrade.leetcodedaily.misc.IsProblem

class FloodFill : IsProblem {
    override fun run() : String {
        val input: Array<IntArray>
        val sr: Int
        val sc: Int
        val color: Int

        when((1..2).random()){
            1 -> {
                input = arrayOf(intArrayOf(1,1,1), intArrayOf(1,1,0), intArrayOf(1,0,1))
                sr = 1
                sc = 1
                color = 2
            }
            2 -> {
                input = arrayOf(intArrayOf(0,0,0), intArrayOf(0,0,0))
                sr = 0
                sc = 0
                color = 0
            }
            else -> {
                input = arrayOf(intArrayOf(1,1,1), intArrayOf(1,1,0), intArrayOf(1,0,1))
                sr = 1
                sc = 1
                color = 2
            }
        }

        var resultStr = "DataSet: ${input.contentDeepToString()}"
        resultStr += "\nsr: $sr, sc: $sc, color: $color"
        val result = floodFill(input, sr, sc, color)
        resultStr += "\nResult: ${result.contentDeepToString()}"

        return resultStr
    }

    private fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        var array = image

        val oldColor = image[sr][sc]
        val maxr = image.size-1
        val maxc = image[0].size-1

        array[sr][sc] = color

        if(sr > 0) {
            if(array[sr-1][sc] == oldColor && array[sr-1][sc] != color){
                array = floodFill(array, sr - 1, sc, color)
            }
        }
        if(sr < maxr){
            if(array[sr+1][sc] == oldColor && array[sr+1][sc] != color) {
                array = floodFill(array, sr + 1, sc, color)
            }
        }
        if(sc > 0) {
            if(array[sr][sc-1] == oldColor && array[sr][sc-1] != color) {
                array = floodFill(array, sr, sc - 1, color)
            }
        }
        if(sc < maxc){
            if(array[sr][sc+1] == oldColor && array[sr][sc+1] != color) {
                array = floodFill(array, sr, sc + 1, color)
            }
        }

        return array
    }
}