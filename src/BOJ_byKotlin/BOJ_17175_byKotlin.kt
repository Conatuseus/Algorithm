package BOJ_byKotlin

fun main() {
    val n = readLine()!!.toInt()
    val dp = IntArray(51)
    dp[0] = 1
    dp[1] = 1

    (2..n).forEach { dp[it] = (dp[it-1] + dp[it-2] +1) % 1000000007 }
    println(dp[n])
}