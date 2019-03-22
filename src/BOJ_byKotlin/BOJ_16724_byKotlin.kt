package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (r,c)=br.readLine()!!.split(' ').map { it.toInt() }
    val map=Array(r){br.readLine()!!.toCharArray()}
    val save=Array(r){IntArray(c)}
    var res=0

    fun go(x:Int,y:Int,k:Int){
        if(save[x][y]!=k&&save[x][y]!=0)  return
        if(save[x][y]==k){
            res++
            return
        }
        when(map[x][y]){
            'L' -> {
                save[x][y]=k
                go(x,y-1,k)
            }
            'R' -> {
                save[x][y]=k
                go(x,y+1,k)
            }
            'U' -> {
                save[x][y]=k
                go(x-1,y,k)
            }
            'D'->{
                save[x][y]=k
                go(x+1,y,k)
            }
        }
    }
    var k=1
    for(i in 0 until r){
        for(j in 0 until c){
            if(save[i][j]==0){
                go(i,j,k++)
            }
        }
    }
    println(res)
}