package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (N,M)=br.readLine()!!.split(" ").map { it.toInt() }
    val arr=Array(N) {br.readLine()!!.split(" ").map { it.toInt() }.toIntArray()}

    for (i in 1 until N) {
        arr[0][i] +=arr[0][i-1]
        arr[i][0] +=arr[i-1][0]
    }

    for (i in 1 until N) {
        for (j in 1 until N) {
            arr[i][j]+=arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1]
        }
    }

    fun sum(startX:Int,startY:Int,endX:Int,endY:Int) :Int{
        if (startX==0&&startY==0) {
            return arr[endX][endY]
        }
        if (startX==0) {
            return arr[endX][endY]-arr[endX][startY-1]
        }
        if (startY==0) {
            return arr[endX][endY]-arr[startX-1][endY]
        }
        return arr[endX][endY]-arr[endX][startY-1]-arr[startX-1][endY]+arr[startX-1][startY-1]
    }

    repeat(M) {
        val (startX,startY,endX,endY) = br.readLine()!!.split(" ").map { it.toInt()-1 }
        println(sum(startX,startY,endX,endY))
    }
}