package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (m,n)=br.readLine()!!.split(' ').map { it.toInt() }
    val map=Array(n){br.readLine()!!.split(' ').map { it.toInt().toString(2)}.toMutableList()}
    for(i in 0 until n){
        for(j in 0 until m){
            while (map[i][j].length!=4){
                map[i][j]="0${map[i][j]}"
            }
        }
    }
    var visit=Array(n){BooleanArray(m)}
    val q=java.util.ArrayDeque<Pair<Int,Int>>()

    fun BFS(i:Int,j:Int):Int{
        visit[i][j]=true
        var countSize=0
        q.add(Pair(i,j))
        while(!q.isEmpty()) {
            val (x, y) = q.poll()
            countSize++
            if(x+1 in 0 until n && y in 0 until m) {
                if (map[x][y][0] == '0' && !visit[x + 1][y]) {
                    visit[x + 1][y] = true
                    q.add(Pair(x + 1, y))
                }
            }
            if(x in 0 until n && y+1 in 0 until m) {
                if (map[x][y][1] == '0' && !visit[x][y + 1]) {
                    visit[x][y + 1] = true
                    q.add(Pair(x, y + 1))
                }
            }
            if(x-1 in 0 until n && y in 0 until m) {
                if (map[x][y][2] == '0' && !visit[x - 1][y]) {
                    visit[x - 1][y] = true
                    q.add(Pair(x - 1, y))
                }
            }
            if(x in 0 until n && y-1 in 0 until m) {
                if (map[x][y][3] == '0' && !visit[x][y - 1]) {
                    visit[x][y - 1] = true
                    q.add(Pair(x, y - 1))
                }
            }
        }
        return countSize
    }

    var roomNum=0
    var maxSize=0
    var combineMax=0
    for(i in 0 until n){
        for(j in 0 until m){
            if(!visit[i][j]){
                visit[i][j]=true
                roomNum++
                maxSize= max(maxSize,BFS(i,j))
            }
        }
    }
    for(i in 0 until n){
        for(j in 0 until m){
            for(k in 0..3){
                if(map[i][j][k]=='1'){
                    visit.forEach { it.fill(false) }
                    map[i][j]=map[i][j].replaceRange(k,k+1,"0")
                    combineMax= max(combineMax,BFS(i,j))
                    map[i][j]=map[i][j].replaceRange(k,k+1,"1")
                }
            }
        }
    }


    println("$roomNum\n$maxSize\n$combineMax")
}