package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))
    val (N,M,A,B,K)=br.readLine()!!.split(' ').map { it.toInt() }
    val matrix=Array(N){IntArray(M)}
    val dx= arrayOf(-1,1,0,0)
    val dy= arrayOf(0,0,-1,1)

    repeat(K){
        val (x,y)=br.readLine()!!.split(' ').map { it.toInt()-1 }
        matrix[x][y]=-1
    }
    val (startX,startY)=br.readLine()!!.split(' ').map { it.toInt()-1 }
    val (endX,endY)=br.readLine()!!.split(' ').map { it.toInt()-1 }

    val q=java.util.ArrayDeque<Triple<Int,Int,Int>>()
    q.add(Triple(startX,startY,0))
    var resChk=false
    fun chk(x:Int,y:Int):Boolean{
        for(i in x until x+A){
            for(j in y until y+B){
                if(i !in 0 until N || j !in 0 until M)  return false
                if(matrix[i][j]==-1)   return false
            }
        }
        return true
    }
    while (!q.isEmpty()){
        val (nX,nY,nStep)=q.poll()
        if(nX==endX&&nY==endY){
            resChk=true
            break
        }
        for(i in 0 until 4){
            val nextX=nX+dx[i]
            val nextY=nY+dy[i]

            if(chk(nextX,nextY)){
                if(matrix[nextX][nextY]==0) {
                    matrix[nextX][nextY] = nStep + 1
                    q.add(Triple(nextX, nextY, nStep + 1))
                }
            }
        }
    }
    bw.write(if(!resChk) "-1\n" else "${matrix[endX][endY]}\n")
    bw.close()
}