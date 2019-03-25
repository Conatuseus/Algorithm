package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))


    val n=br.readLine()!!.toInt()
    val str=br.readLine()

    val map=Array(101){BooleanArray(101)}

    var nowX=50
    var nowY=50
    var nowDir=0
    val dx= arrayOf(1,0,-1,0)
    val dy= arrayOf(0,-1,0,1)
    var lx=50
    var rx=50
    var ly=50
    var ry=50
    map[50][50]=true
    for(i in 0 until str.length){
        when(str[i]){
            'R' -> nowDir=(nowDir+1)%4
            'L' -> nowDir=(nowDir+3)%4
            else ->{
                nowX+=dx[nowDir]
                nowY+=dy[nowDir]
            }
        }
        map[nowX][nowY]=true
        lx= min(nowX,lx)
        rx= max(nowX,rx)
        ly= min(nowY,ly)
        ry= max(nowY,ry)
    }
    for(i in lx..rx){
        for(j in ly..ry){
            bw.write("${if(map[i][j]) '.' else '#'}")
        }
        bw.write("\n")
    }

    bw.close()
}