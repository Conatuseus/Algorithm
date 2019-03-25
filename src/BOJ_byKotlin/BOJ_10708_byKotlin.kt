package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br= BufferedReader(InputStreamReader(System.`in`))
    val n=br.readLine()!!.toInt()
    val m=br.readLine()!!.toInt()
    val target=br.readLine()!!.split(' ').map { it.toInt()-1 }.toIntArray()
    val res=IntArray(n)
    repeat(m){
        val nowT=target[it]
        val score=br.readLine()!!.split(' ').map { it.toInt()-1 }.toIntArray()
        for(i in 0 until n){
            if(score[i]==nowT)  res[i]++
        }
        res[nowT]+=score.filter { it!=nowT}.count()
    }
    res.forEach { println(it) }
}