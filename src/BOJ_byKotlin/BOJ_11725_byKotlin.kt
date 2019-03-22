package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br= BufferedReader(InputStreamReader(System.`in`))
    val n=br.readLine()!!.toInt()
    val adj=Array(n+1){ mutableListOf<Int>()}
    val visit=BooleanArray(n+1)
    val res=IntArray(n+1)
    repeat(n-1){
        val (s,e)=br.readLine()!!.split(' ').map { it.toInt() }
        adj[s].add(e)
        adj[e].add(s)
    }
    fun go(now:Int){
        for(next in adj[now]){
            if(!visit[next]) {
                visit[next] = true
                res[next]=now
                go(next)
            }
        }
    }
    visit[1]=true
    go(1)
    println(res.filterIndexed { index, i -> index>1 }.joinToString("\n"))
}