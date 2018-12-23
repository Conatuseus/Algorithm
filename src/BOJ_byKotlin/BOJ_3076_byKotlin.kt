package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (r,c)=br.readLine()!!.split(' ').map { it.toInt() }
    val (a,b)=br.readLine()!!.split(' ').map { it.toInt() }

    for(i in 0 until r*a){
        for(j in 0 until c*b){
            if(i%(a*2) < a == j%(b*2) < b)  print("X")
            else print(".")
        }
        println()
    }
}