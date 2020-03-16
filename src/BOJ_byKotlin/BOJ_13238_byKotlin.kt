package BOJ_byKotlin

import kotlin.math.abs
import kotlin.math.min

fun main() {
    val input= readLine()!!

    var now = 0
    var res=0
    for (ch in input) {
        val next=ch-'A'
        val fir= abs(next-now)
        val sec = if (now>next) abs(next+26-now) else abs(now+26-next)
        res+= min(fir,sec)
        now=next
    }
    println(res)
}