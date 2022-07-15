package pt.eandrade.leetcodedaily.problems

import pt.eandrade.leetcodedaily.misc.IsProblem
import java.util.*

class ValidAnagram : IsProblem {
    override fun run() : String {
        val word1: String
        val word2: String

        when((1..2).random()){
            1 -> {
                word1 = "anagram"
                word2 = "nagaram"
            }
            2 -> {
                word1 = "rat"
                word2 = "car"
            }
            else -> {
                word1 = ""
                word2 = ""
            }
        }

        var resultStr = "DataSet: $word1 & $word2"
        val resultBoolean = isAnagram(word1, word2)
        resultStr += "\nResult: $resultBoolean"

        return resultStr
    }

    private fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length){
            return false
        }

        val array1 = IntArray(26)
        for (c in s){
            array1[c.toInt()-97]++
        }

        val array2 = IntArray(26)
        for (c in t){
            array2[c.toInt()-97]++
        }

        return array1.contentEquals(array2)
    }
}