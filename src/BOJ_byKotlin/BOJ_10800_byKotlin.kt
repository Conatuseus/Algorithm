package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val N=br.readLine()!!.toInt()

    val arr=Array(200001){ mutableListOf<Pair<Int,Int>>() }
    repeat(N){
        val (color,size)=br.readLine()!!.split(' ').map { it.toInt() }
        arr[size].add(Pair(it,color))
    }

    val res=IntArray(200001)
    var sum=0
    val beforeSum=IntArray(200001)

    for(i in 1..2000){

        for(j in 0 until arr[i].size){
            res[arr[i][j].first]=sum-beforeSum[arr[i][j].second]
        }
        for(j in 0 until arr[i].size){
            beforeSum[arr[i][j].second]+=i
            sum+=i
        }
    }
    bw.write(res.filterIndexed { index, _ -> index in 0 until N }.joinToString("\n"))
    bw.close()
}