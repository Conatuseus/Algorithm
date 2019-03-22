package BOJ_byKotlin

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val bw=BufferedWriter(OutputStreamWriter(System.out))
    val (n,m)= readLine()!!.split(' ').map { it.toInt() }
    val arr= readLine()!!.split(' ').map { it.toInt() }.sorted()
    val visit=BooleanArray(n)
    val res=IntArray(m)

    fun go(i:Int,s:Int){
        res[s-1]=arr[i]
        if(s==m)    bw.write(res.joinToString(" ")+"\n")
        else{
            for(next in 0 until n){
                if(!visit[next]){
                    visit[next]=true
                    go(next,s+1)
                    visit[next]=false
                }
            }
        }
    }
    for(i in 0 until n){
        visit[i]=true
        go(i,1)
        visit[i]=false
    }
    bw.close()
}