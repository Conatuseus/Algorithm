package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (N,L,R)=br.readLine()!!.split(' ').map { it.toInt() }
    val dp=Array(N+1){Array(N+1){LongArray(N+1)}}

    dp[1][1][1]=1
    for(i in 2..N){
        for(j in 1..L){
            for(k in 1..R){
                dp[i][j][k]=(dp[i-1][j-1][k]+dp[i-1][j][k-1]+(i-2)*dp[i-1][j][k])%1000000007
            }
        }
    }
    bw.write("${dp[N][L][R]}\n")
    bw.close()
}