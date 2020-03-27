package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))

    val n=br.readLine()!!.toInt()
    val arr=br.readLine()!!.split(" ").map { it.toInt() }

    var res=0
    var minValue=Int.MAX_VALUE
    for (i in 0 until n) {
        if (arr[i]==-1) {
            res+= if (minValue!= Int.MAX_VALUE) minValue else 0
            minValue=Int.MAX_VALUE
            continue
        }
        minValue= min(minValue, arr[i])
    }
    if (minValue!= Int.MAX_VALUE) {
        res+=minValue
    }
    println(res)
}