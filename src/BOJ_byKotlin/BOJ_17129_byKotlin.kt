package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (r,c)=br.readLine()!!.split(' ').map { it.toInt() }
    val map=Array(r){ br.readLine()!! }
    val visit=Array(r){BooleanArray(c)}
    val dx= arrayOf(-1,0,1,0)
    val dy= arrayOf(0,-1,0,1)

    var startX=0
    var startY=0
    for(i in 0 until r){
        for(j in 0 until c){
            if(map[i][j]=='2'){
                visit[i][j]=true
                startX=i
                startY=j
            }
        }
    }
    fun isAvail(x:Int,y:Int)=x in 0 until r && y in 0 until c

    var res=0
    val q=java.util.ArrayDeque<Triple<Int,Int,Int>>()
    q.add(Triple(startX,startY,0))
    while (!q.isEmpty()){
        val (x,y,dist)=q.poll()
        if(map[x][y]>'2'){
            res=dist
            break
        }
        for(i in 0 until 4){
            val bx=x+dx[i]
            val by=y+dy[i]
            if(isAvail(bx,by)){
                if(map[bx][by]!='1'&&!visit[bx][by]){
                    visit[bx][by]=true
                    q.add(Triple(bx,by,dist+1))
                }
            }
        }
    }
    bw.write(if(res==0) "NIE" else "TAK\n$res")

    bw.close()
}