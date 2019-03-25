package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (n,m)=br.readLine()!!.split(' ').map { it.toInt() }
    val jisi=IntArray(n){br.readLine()!!.toInt()}
    val dad=IntArray(m){br.readLine()!!.toInt()}
    var res=0
    var now=0
    for(i in 0 until m){
        res++
        now+=dad[i]
        if(now>=n)  break
        if(now+jisi[now]>=n)    break
        now+=jisi[now]
    }
    println(res)
}