package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (r,c)=br.readLine()!!.split(' ').map { it.toInt() }
    val map=Array(r){br.readLine()!!.toCharArray()}
    val res=IntArray(5)
    for(i in 0 until r-1){
        for(j in 0 until c-1){
            var carCount=0
            if(map[i][j]=='#'||map[i+1][j]=='#'||map[i][j+1]=='#'||map[i+1][j+1]=='#')  continue
            if(map[i][j]=='X')  carCount++
            if(map[i+1][j]=='X') carCount++
            if(map[i+1][j+1]=='X')  carCount++
            if(map[i][j+1]=='X') carCount++
            res[carCount]++
        }
    }
    println(res.joinToString("\n"))
}