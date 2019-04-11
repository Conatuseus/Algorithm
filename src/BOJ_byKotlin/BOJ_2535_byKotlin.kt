package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br= BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val n=br.readLine()!!.toInt()
    val visit=IntArray(101)
    var count=0
    var i=0
    val list=List(n){
        val (country,student,score)=br.readLine()!!.split(' ').map { it.toInt() }
        Triple(country,student,score)
    }.sortedByDescending { it.third }
    while (count<3){
        if(visit[list[i].first]!=2){
            count++
            visit[list[i].first]++
            bw.write("${list[i].first} ${list[i].second}\n")
        }
        i++
    }
    bw.close()
}