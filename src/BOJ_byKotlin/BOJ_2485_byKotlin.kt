package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val N=br.readLine()!!.toInt()
    val arr=Array(N){ br.readLine()!!.toInt()}.sorted()

    fun gcd(a:Int,b:Int):Int{
        return if(b==0) a else gcd(b,a%b)
    }

    var now=arr[1]-arr[0]
    for(i in 2 until N){
        now=gcd(now,arr[i]-arr[i-1])
    }
    var res=0
    for(i in 1 until N){
        res+=(arr[i]-arr[i-1])/now -1
    }
    bw.write("$res\n")
    bw.close()
}