package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val n=br.readLine()!!.toInt()
    val point=Array(n+1){ mutableListOf<Int>()}

    repeat(n){
        val (loc,color)=br.readLine()!!.split(' ').map { it.toInt() }
        point[color].add(loc)
    }
    point.forEach { it.sort() }
    var res=0L
    for(i in 0..n){
        if(point[i].size>1){
            for(j in 0 until point[i].size){
                res+=if(j-1>=0&&j+1<point[i].size)  min(point[i][j]-point[i][j-1],point[i][j+1]-point[i][j])
                    else if(j-1>=0) point[i][j]-point[i][j-1]
                    else point[i][j+1]-point[i][j]
            }
        }
    }
    bw.write("$res\n")
    bw.close()
}