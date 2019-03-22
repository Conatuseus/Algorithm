package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (n,firRobot,secRobot)=br.readLine()!!.split(' ').map { it.toInt()}

    val adj=Array(n+1){LinkedList<Pair<Int,Int>>()}
    repeat(n-1){
        val (s,e,d)=br.readLine()!!.split(' ').map { it.toInt() }
        adj[s].add(Pair(e,d))
        adj[e].add(Pair(s,d))
    }

    val res= mutableListOf<Int>()
    val visit=BooleanArray(n+1)
    fun go(now:Int,step:Int){
        if(now==secRobot)   return
        for(p in adj[now]){
            val next=p.first
            val nextD=p.second
            if(!visit[next]&&!visit[secRobot]){
                visit[next]=true
                res.add(step,nextD)
                go(next,step+1)
                if(!visit[secRobot])
                    res.removeAt(step)
            }
        }
    }

    visit[firRobot]=true
    go(firRobot,0)

    bw.write("${if(res.size>=2) res.sum()-res.max()!! else 0}\n")
    bw.close()
}