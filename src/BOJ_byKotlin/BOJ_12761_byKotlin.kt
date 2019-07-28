package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (A,B,N,M)=br.readLine()!!.split(' ').map { it.toInt() }
    val visit=BooleanArray(100001){false}
    visit[N]=true
    val q=java.util.ArrayDeque<Pair<Int,Int>>()
    q.add(Pair(N,0))
    fun isAvail(next:Int)=next in 0..100000 && !visit[next]

    while (!q.isEmpty()){
        val (here,count)=q.poll()
        if(here==M){
            bw.write("$count\n")
            break
        }
        if(isAvail(here+1)){
            visit[here+1]=true
            q.add(Pair(here+1,count+1))
        }
        if(isAvail(here-1)){
            visit[here-1]=true
            q.add(Pair(here-1,count+1))
        }
        if(isAvail(here+A)){
            visit[here+A]=true
            q.add(Pair(here+A,count+1))
        }
        if(isAvail(here-A)){
            visit[here-A]=true
            q.add(Pair(here-A,count+1))
        }
        if(isAvail(here+B)){
            visit[here+B]=true
            q.add(Pair(here+B,count+1))
        }
        if(isAvail(here-B)){
            visit[here-B]=true
            q.add(Pair(here-B,count+1))
        }
        if(isAvail(here*A)){
            visit[here*A]=true
            q.add(Pair(here*A,count+1))
        }
        if(isAvail(here*B)){
            visit[here*B]=true
            q.add(Pair(here*B,count+1))
        }
    }

    bw.close()
}