package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(br.readLine()!!.toInt()) {
        val numStr = br.readLine()!!
        val reverseNumStr = numStr.reversed()

        val sum = (numStr.toInt() + reverseNumStr.toInt()).toString()
        var res = true
        for (i in 0 until sum.length / 2) {
            if (sum[i] != sum[sum.length - 1 - i]) {
                res = false
                break
            }
        }
        bw.write(if(res) "YES\n" else "NO\n")
    }
    bw.close()
}