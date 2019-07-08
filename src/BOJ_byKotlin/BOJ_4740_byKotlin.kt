package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    while (true){
        val str=br.readLine()!!
        if(str == "***"){
            break
        }
        bw.write("${str.reversed()}\n")
    }

    bw.close()
}