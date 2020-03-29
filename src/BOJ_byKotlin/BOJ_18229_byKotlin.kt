package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))

    val (N,M,K) = br.readLine()!!.split(" ").map { it.toInt() }
    val arr = Array(N) {br.readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    val sum = IntArray(N)
    var resIndex = 0
    var resCount = 0
    for (i in 0 until M) {
        for (j in 0 until N) {
            sum[j] +=arr[j][i]
            if (sum[j]>=K) {
                resIndex = j+1
                resCount = i+1
                break
            }
        }
        if (resIndex!=0) {
            break
        }
    }
    println("$resIndex $resCount")
}