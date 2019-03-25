package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val n=br.readLine()!!.toInt()
    val arr=Array(n){br.readLine()!!.toInt()}

    var res=0
    var now=n
    for(i in n-1 downTo 0){
        if(arr[i]==now)   now--
        else    res++
    }
    bw.write("$res\n")
    bw.close()
}