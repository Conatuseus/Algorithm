package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br= BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))
    val n=br.readLine()!!.toInt()
    val arr=br.readLine()!!.split(' ').map { it.toInt()}.toIntArray()
    val dp=Array(n){BooleanArray(n)}
    for(i in 0 until n){
        dp[i][i]=true
        if(i<n-1){
            if(arr[i]==arr[i+1]){
                dp[i][i+1]=true
            }
        }
    }
    for(k in 2 until n) {
        for (i in 0 until n) {
                if(i+k<n){
                    if(dp[i+1][i+k-1]&& arr[i]==arr[i+k]){
                        dp[i][i+k]=true
                    }
                }
        }
    }

    repeat(br.readLine()!!.toInt()){
        val (s,e)=br.readLine()!!.split(' ').map { it.toInt()-1 }
        bw.write("${if(dp[s][e]) 1 else 0}\n")
    }
    bw.close()
}