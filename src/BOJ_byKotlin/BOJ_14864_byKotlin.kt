package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (n,m)=br.readLine()!!.split(' ').map { it.toInt() }
    val arr=IntArray(n+1){it}
    val visit=BooleanArray(n+1)
    repeat(m){
        val (x,y)=br.readLine()!!.split(' ').map { it.toInt() }
        arr[x]++
        arr[y]--
    }
    for(i in 1..n){
        visit[arr[i]]=true
    }
    var chk=true
    for(i in 1..n){
        if(!visit[i])   chk=false
    }
    bw.write(if(chk) arr.filter { it>0 }.joinToString(" ")+"\n" else "-1\n" )
    bw.close()
}