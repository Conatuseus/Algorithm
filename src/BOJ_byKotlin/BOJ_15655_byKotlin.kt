package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (n,m)=br.readLine()!!.split(' ').map { it.toInt() }
    val arr=br.readLine()!!.split(' ').map { it.toInt() }.sorted()
    val res=IntArray(m)

    fun go(i:Int,s:Int){
        if(s>0) res[s-1]=arr[i]
        if(s==m)    bw.write(res.joinToString(" ")+"\n")
        else{
            for(next in i+1 until n){
                go(next,s+1)
            }
        }
    }
    go(-1,0)
    bw.close()
}