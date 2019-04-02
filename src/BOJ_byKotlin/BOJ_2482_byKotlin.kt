package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val N=br.readLine()!!.toInt()
    val K=br.readLine()!!.toInt()

    val dp=Array(N+1){LongArray(N+1)}
    val mod=1000000003L
    for(i in 1..3){
        dp[i][1]=i.toLong()
    }
    for(i in 4..N){
        for(j in 1..(i/2)){
            if(j==1)    dp[i][j]=i.toLong()
            else{
                dp[i][j]=(dp[i-1][j]+dp[i-2][j-1])%mod
            }
        }
    }
    bw.write("${dp[N][K]}\n")
    bw.close()
}