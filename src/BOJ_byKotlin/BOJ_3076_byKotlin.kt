package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (r,c)=br.readLine()!!.split(' ').map { it.toInt() }
    val (a,b)=br.readLine()!!.split(' ').map { it.toInt() }

//    fun insert(x:Int,y:Int,type:Int){
//        for(i in x until x+a){
//            for(j in y until y+b){
//                map[i][j]=if(type==1)  'X' else '.'
//            }
//        }
//    }
//
//    var type=1
//    for(i in 0 until r*a step a){
//        for(j in 0 until c*b step b){
//            insert(i,j,type)
//            type*=-1
//        }
//    }
    for(i in 0 until r*a){
        for(j in 0 until c*b){
            if(i%(a*2) < a == j%(b*2) < b)  print("X")
            else print(".")
        }
        println()
    }
}