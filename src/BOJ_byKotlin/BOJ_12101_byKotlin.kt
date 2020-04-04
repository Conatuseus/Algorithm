package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (N,K) = br.readLine()!!.split(" ").map { it.toInt() }

    val res=ArrayList<String>()

    fun go(now:Int, str:String) {
        if (now==N) {
            res.add(str)
            return
        }
        if (now>N) {
            return
        }

        for (i in 1..3) {
            go(now+i,"$str+$i")
        }
    }

    for (i in 1..3) {
        go(i,"$i")
    }

    println(if (res.size<K) -1 else res[K-1])
}