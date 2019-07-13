package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))
    val arr=Array(br.readLine()!!.toInt()){br.readLine()!!.toInt() }.sorted()
    arr.forEach { bw.write("$it\n") }
    bw.close()
}