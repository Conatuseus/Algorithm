package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    br.readLine()!!.toInt()
    val res = IntArray(53)
    br.readLine()!!.split(" ").map { it.toInt() }.forEach { res[it]++ }
    br.readLine()!!.forEach { if (it==' ') res[0]-- else if (it.isUpperCase()) res[it-'A'+1]-- else res[it-'a'+27]--}
    println(if (res.none { it != 0 }) "y" else "n")
}