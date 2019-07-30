package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (n,m)=br.readLine()!!.split(' ').map { it.toInt() }
    val num=br.readLine()!!.split(' ').map { it.toInt() }.toSet().sorted().toIntArray()
    val res=IntArray(m)
    fun go(index:Int,count:Int){
        if(count<m){
            res[count]=num[index]
            if(count+1==m){
                bw.write("${res.toList().joinToString(" ")}\n")
            }
            else {
                for (i in 0 until num.size) {
                    go(i, count + 1)
                }
            }
        }
    }
    for (i in 0 until num.size){
        go(i,0)
    }
    bw.close()
}