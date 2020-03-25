package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val T=br.readLine()!!.toInt()
    for (i in 1..T) {
        val (a,b) = br.readLine()!!.split(' ').map { it.toInt() }
        println("Case #$i: $a + $b = ${a+b}")
    }
}