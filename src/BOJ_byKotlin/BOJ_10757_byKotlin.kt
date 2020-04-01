package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))

    val (fir,sec) = br.readLine()!!.split(" ")
    val res = IntArray(max(fir.length,sec.length))

    var firIndex=fir.length-1
    var secIndex=sec.length-1

    for (i in res.size-1 downTo 0) {
        when {
            firIndex<0 -> {
                res[i] = sec[secIndex] -'0'
                secIndex--
            }
            secIndex<0 -> {
                res[i]= fir[firIndex]- '0'
                firIndex--
            }
            else -> {
                res[i] = (fir[firIndex]-'0') + (sec[secIndex]-'0')
                firIndex--
                secIndex--
            }
        }
    }

    var carry = false
    for (i in res.size-1 downTo 0) {
        if (carry) res[i] +=1
        carry = res[i]>=10
        if (carry) res[i]-=10
    }

    if (carry) print(1)
    println(res.joinToString(""))
}