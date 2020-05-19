package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    var idx=0
    while (true) {
        val (l,p,v)=br.readLine()!!.split(" ").map { it.toInt() }
        if (l==0) break
        println("Case ${++idx}: ${(v/p) *l + if ((v%p)>=l) l else (v%p)}")
    }
}