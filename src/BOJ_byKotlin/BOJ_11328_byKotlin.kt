package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))

    repeat(br.readLine()!!.toInt()) {
        val (fir,sec) =br.readLine()!!.split(" ")

        var res=fir.length==sec.length
        if (res) {
            val arr = IntArray(27)
            for (i in fir.indices) {
                arr[fir[i]-'a']++
                arr[sec[i]-'a']--
            }
            res = arr.none { it != 0 }
        }
        println(if (res) "Possible" else "Impossible")
    }
}