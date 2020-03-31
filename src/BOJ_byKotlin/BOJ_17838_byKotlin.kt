package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))

    val N=br.readLine()!!.toInt()
    val arr=Array(N){br.readLine()!!}

    fun isValid(str:String) :Boolean {
        if (str.length!=7) {
            return false
        }

        if (str[0]==str[1] && str[0]==str[4]) {
            if (str[2]!=str[1]) {
                if (str[2]==str[3]&&str[2]==str[5]&&str[2]==str[6]) {
                    return true
                }
            }
        }
        return false
    }

    for (str in arr) {
        println(if (isValid(str)) 1 else 0)
    }
}