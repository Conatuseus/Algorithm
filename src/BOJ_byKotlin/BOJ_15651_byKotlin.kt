package BOJ_byKotlin

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val (n,m)= readLine()!!.split(' ').map { it.toInt() }
    val bw=BufferedWriter(OutputStreamWriter(System.out))
    val res=IntArray(m)
    val visit=BooleanArray(n+1)
    fun go(i:Int,size:Int){
        res[size-1]=i
        if(size==m) bw.write(res.joinToString(" ")+"\n")
        else{
            for(next in 1..n){
                visit[next]=true
                go(next,size+1)
                visit[next]=false
            }
        }
    }
    for(i in 1..n) {
        visit[i]=true
        go(i,1)
        visit[i]=false
    }
    bw.close()
}