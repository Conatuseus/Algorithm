package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val visit=Array(6){BooleanArray(6)}
    val dx= arrayOf(-2,-2,-1,-1,1,1,2,2)
    val dy= arrayOf(1,-1,2,-2,2,-2,-1,1)
    fun chk(hereX:Int,hereY:Int,nextX:Int,nextY:Int):Boolean{
        for(i in 0 until 8){
            if(nextX-hereX==dx[i]&&nextY-hereY==dy[i]){
                return true
            }
        }
        return false
    }
    var startX=0
    var startY=0
    var hereX=0
    var hereY=0
    var res=true
    var i=0
    while(i++<36){
        if(i==1){
            val str=br.readLine()!!
            startX=(str[0]-65).toInt()
            startY=str[1].toInt()-49
            hereX=(str[0]-65).toInt()
            hereY=str[1].toInt()-49
            visit[hereX][hereY]=true
        }
        else{
            val str=br.readLine()!!
            val nextX=(str[0]-65).toInt()
            val nextY=str[1].toInt()-49
            if(chk(hereX,hereY,nextX,nextY)&&!visit[nextX][nextY]){
                visit[nextX][nextY]=true
                hereX=nextX
                hereY=nextY
            }
            else{
                res=false
                break
            }
        }
    }
    println(if(res&&chk(startX,startY,hereX,hereY)) "Valid" else "Invalid")
}