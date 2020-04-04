package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val str=br.readLine()!!
    val dp=IntArray(str.length+1)

    var resFlag=true
    dp[0]=1
    dp[1]=1
    if (str[0]=='0') resFlag=false

    for (i in 2..str.length) {
        if (str[i-1]=='0'&&(str[i-2]>'2'||str[i-2]=='0')){
            resFlag=false
            break
        }
        if (str[i-1]>'0') {
            dp[i] = dp[i-1]
        }
        val num = (str[i-2]-'0')*10 + (str[i-1]-'0')
        if (num in 10..26) {
            dp[i] = (dp[i] + dp[i-2]) % 1000000
        }
    }
    println(if (resFlag) dp[str.length] else 0)
}