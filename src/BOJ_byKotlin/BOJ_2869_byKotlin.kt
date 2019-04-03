package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))
    val (A,B,V)=br.readLine()!!.split(' ').map { it.toDouble() }
    bw.write("${Math.ceil(((V-A)/(A-B))+1).toInt()}\n")
    bw.close()
}