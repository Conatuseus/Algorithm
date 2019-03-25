package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val N=br.readLine()!!.toInt()
    val words=Array(N){br.readLine()}
    val alphaSum=IntArray(26)

    for(word in words){
        var mul=1
        for(i in word.length-1 downTo 0){
            alphaSum[word[i]-'A']+=mul
            mul*=10
        }
    }
    alphaSum.sortDescending()
    var res=0
    for(i in 0 until 10){
        res+=alphaSum[i]*(9-i)
    }
    bw.write("$res\n")
    bw.close()
}