package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (N,M)=br.readLine()!!.split(' ').map { it.toInt() }
    val isKnow=BooleanArray(N+1)
    br.readLine()!!.split(' ').map { it.toInt() }.filterIndexed { index, i -> index>0 }.forEach { isKnow[it]=true }
    val arr=Array(M){br.readLine()!!.split(' ').map { it.toInt() } }

    var res=M
    while (true){
        var chk=false
        for(i in 0 until M){
            if(arr[i][0]==0)    continue
            for(j in 1 until arr[i].size){
                if(isKnow[arr[i][j]]){
                    for(k in 1 until arr[i].size){
                        if(!isKnow[arr[i][k]]){
                            chk=true
                            isKnow[arr[i][k]]=true
                        }
                    }
                }
            }
        }
        if(!chk)    break
    }
    for(i in 0 until M){
        if(arr[i][0]!=0&&isKnow[arr[i][1]]) res--
    }
    bw.write("$res\n")
    bw.close()
}