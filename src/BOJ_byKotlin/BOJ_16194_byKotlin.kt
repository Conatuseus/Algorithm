package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val n=br.readLine()!!.toInt()
    val arr=br.readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    val dp=IntArray(n+1)
    dp[1] = arr[0]

    for (i in 1..n) {
        dp[i]=Int.MAX_VALUE
        for (j in 1..i) {
            dp[i] = min(dp[i-j]+arr[j-1], dp[i])
        }
    }
    println(dp[n])
}