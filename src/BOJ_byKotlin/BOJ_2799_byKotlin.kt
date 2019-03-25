package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (n,m)=br.readLine()!!.split(' ').map { it.toInt() }
    val map=Array(4*n+n+1){br.readLine()!!}
    val res=IntArray(5)
    fun checkCase(x:Int,y:Int):Int{
        if(map[x][y]=='.')  return 0
        if(map[x+1][y]=='.')    return 1
        if(map[x+2][y]=='.')    return 2
        if(map[x+3][y]=='.')    return 3
        return 4
    }
    for(i in 1 until 4*n+n+1 step 5){
        for(j in 1 until 4*m+m+1 step 5){
            res[checkCase(i,j)]++
        }
    }
    println(res.joinToString(" "))
}