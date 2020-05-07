package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))

    val n=br.readLine()!!.toInt()
    val (startRow,startCol,endRow,endCol)=br.readLine()!!.split(" ").map { it.toInt() }
    val visit=Array(n){BooleanArray(n){false} }
    visit[startRow][startCol]=true

    val dx= intArrayOf(-2,-2,0,0,2,2)
    val dy= intArrayOf(-1,1,-2,2,-1,1)

    data class Knight(var row:Int, var col:Int, val step:Int)

    val q=LinkedList<Knight>()
    q.add(Knight(startRow,startCol,0))

    fun isValid(row:Int,col:Int)=row in 0 until n && col in 0 until n

    var res=-1

    while (!q.isEmpty()) {
        val now=q.poll()
        if (now.row==endRow&&now.col==endCol) {
            res=now.step
            break
        }
        for (i in 0 until 6) {
            val nextRow=now.row+dx[i]
            val nextCol=now.col+dy[i]
            if (isValid(nextRow,nextCol) && !visit[nextRow][nextCol]) {
                visit[nextRow][nextCol]=true
                q.add(Knight(nextRow,nextCol,now.step+1))
            }
        }
    }
    println(res)
}