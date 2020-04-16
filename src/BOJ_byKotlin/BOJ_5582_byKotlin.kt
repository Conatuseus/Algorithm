package BOJ_byKotlin

import kotlin.math.max

fun main() {
    val fir= readLine()!!
    val sec= readLine()!!
    val lcs=Array(fir.length+1){IntArray(sec.length+1)}
    var res=0

    for (i in fir.indices) {
        for (j in sec.indices) {
            if (fir[i]==sec[j]) lcs[i+1][j+1]=lcs[i][j]+1
            res= max(res, lcs[i+1][j+1])
        }
    }

    println(res)
}