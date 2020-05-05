package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val n=br.readLine()!!.toInt()
    val arr=br.readLine()!!.split(" ").map { it.toInt() }

    val dp=IntArray(n)
    val pairs= arrayListOf<Pair<Int,Int>>()
    var idx=0

    dp[0]=arr[0]
    pairs.add(Pair(0,arr[0]))

    fun lowerBound(arr: IntArray, end: Int, target: Int): Int {
        var s = 0
        var e = end

        while (e > s)
        {
            val mid = (s + e) / 2
            if (arr[mid] >= target)
                e = mid
            else s = mid + 1
        }
        return e
    }

    for (i in 1 until n) {
        if (dp[idx]<arr[i]) {
            dp[++idx]=arr[i]
            pairs.add(Pair(idx,arr[i]))
            continue
        }
        val lowerbound=lowerBound(dp,idx,arr[i])
        dp[lowerbound]=arr[i]
        pairs.add(Pair(lowerbound,arr[i]))
    }

    println(idx+1)
    val stack=Stack<Int>()
    for (i in n-1 downTo 0) {
        if (pairs[i].first==idx) {
            stack.push(pairs[i].second)
            idx--
        }
    }

    println(stack.reversed().joinToString(" "))
}