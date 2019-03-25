package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (r,c)=br.readLine()!!.split(' ').map { it.toInt() }
    val puzzle=Array(r){br.readLine()!!}
    val words= mutableListOf<String>()

    for(i in 0 until r){
        puzzle[i].split('#').filter { it.length>=2 }.forEach { words.add(it) }
    }
    for(i in 0 until c){
        val sb=StringBuilder()
        for(j in 0 until r){
            sb.append(puzzle[j][i])
        }
        sb.toString().split('#').filter { it.length>=2 }.forEach { words.add(it) }
    }
    words.sort()
    bw.write("${words[0]}\n")
    bw.close()

}