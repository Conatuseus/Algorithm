package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (n,m)=br.readLine()!!.split(' ').map { it.toInt() }
    val cost=Array(n){br.readLine()!!.toInt()}
    val check=Array(m){br.readLine()!!.toInt()}
    val res=IntArray(n)

    for(i in 0 until m){
        for(j in 0 until n){
            if(cost[j]<=check[i]){
                res[j]++
                break
            }
        }
    }
    println(res.indexOf(res.max()!!)+1)
}