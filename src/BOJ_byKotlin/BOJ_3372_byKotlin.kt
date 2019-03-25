package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val n=br.readLine()!!.toInt()
    val arr=Array(n){br.readLine()!!.split(' ').map { it.toInt() }}
    val dp=Array(n){Array(n){BigInteger.valueOf(0)}}
    dp[0][0]=BigInteger.valueOf(1)
    for(i in 0 until n){
        for(j in 0 until n){
            if(i==n-1&&j==n-1)  break
            if(i+arr[i][j]<n){
                dp[i+arr[i][j]][j]=dp[i+arr[i][j]][j].add(dp[i][j])
            }
            if(j+arr[i][j]<n){
                dp[i][j+arr[i][j]]=dp[i][j+arr[i][j]].add(dp[i][j])
            }
        }
    }
    bw.write("${dp[n-1][n-1]}\n")
    bw.close()
}