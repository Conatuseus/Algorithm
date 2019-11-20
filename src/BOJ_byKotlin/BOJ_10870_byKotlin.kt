package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))

    val fibo=LongArray(21)
    fibo[1]=1

    for (i in 2..20) {
        fibo[i] = fibo[i-1] + fibo[i-2]
    }
    println(fibo[br.readLine()!!.toInt()])
}