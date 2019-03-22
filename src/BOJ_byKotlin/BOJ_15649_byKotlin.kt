package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br= BufferedReader(InputStreamReader(System.`in`))
    val (n,m)=br.readLine()!!.split(' ').map { it.toInt() }
    val res=IntArray(m+1)
    val visit=BooleanArray(n+1)
    fun go(i:Int,size:Int){
        res[size]=i
        if(size==m){
            println(res.filterNot { it==0 }.joinToString(" "))
        }
        else {
            for (next in 1..n) {
                if (!visit[next]) {
                    visit[next] = true
                    go(next,size+1)
                    visit[next] = false
                }
            }
        }
    }
    for(i in 1..n){
        visit[i]=true
        go(i,1)
        visit[i]=false
    }
}