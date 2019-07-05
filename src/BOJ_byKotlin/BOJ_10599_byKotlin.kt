package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))
    while (true){
        val num=br.readLine()!!.trim().split(' ').map { it.toInt() }.sorted()
        if(num.filter { it!=0 }.count()==0) break
        bw.write("${num[2]-num[1]} ${num.last()-num.first()}\n")
    }
    bw.close()
}