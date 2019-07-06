package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (T,east,west,north,south)=br.readLine()!!.split(' ').map { it.toDouble() }
    val direction= arrayOf(east/100,west/100,north/100,south/100)
    val dx= arrayOf(0,0,-1,1)
    val dy= arrayOf(1,-1,0,0)
    val n=T.toInt()
    val visit=Array(30){BooleanArray(30)}
    var res=0.0

    fun go(x:Int,y:Int,count:Int,sum:Double){
        if(count==n){
            res+=sum
            return
        }

        for (i in 0 until 4){
            val nextX=x+dx[i]
            val nextY=y+dy[i]
            if(!visit[nextX][nextY]){
                visit[nextX][nextY]=true
                go(nextX,nextY,count+1,sum*direction[i])
                visit[nextX][nextY]=false
            }
        }

    }
    visit[14][14]=true
    go(14,14,0,1.0)
    bw.write("${String.format("%.10f",res)}\n")
    bw.close()
}