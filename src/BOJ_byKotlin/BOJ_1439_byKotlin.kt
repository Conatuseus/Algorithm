package BOJ_byKotlin

import kotlin.math.min

fun main() {
    val str= readLine()!!

    var toZeroCount=0
    var toOneCount=0

    for (i in str.indices) {
        if (i==0) {
            when(str[i]) {
                '0' -> toOneCount++
                else -> toZeroCount++
            }
            continue
        }

        if (str[i-1]!=str[i]) {
            when(str[i]) {
                '0' -> toOneCount++
                else -> toZeroCount++
            }
        }
    }

    println(min(toZeroCount, toOneCount))
}