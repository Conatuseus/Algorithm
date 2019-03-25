package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))

    val n=br.readLine()!!.toInt()
    val l=br.readLine()!!.split(' ').map { it.toInt() }
    val r=br.readLine()!!.split(' ').map { it.toInt() }
    val dp=Array(n+1){IntArray(n+1)}
    val visit=Array(n+1){BooleanArray(n+1)}
    fun go(i:Int,j:Int):Int{
        if(i>n||j>n)    return 0
        if(!visit[i][j]){
            visit[i][j]=true
            dp[i][j]=if(l[i-1]>r[j-1]) go(i,j+1)+r[j-1] else max(go(i+1,j),go(i+1,j+1))
        }
        return dp[i][j]
    }
    println(go(1,1))
}