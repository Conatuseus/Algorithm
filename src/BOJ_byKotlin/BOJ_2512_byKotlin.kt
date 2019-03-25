package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val n=br.readLine()!!.toInt()
    val arr=br.readLine()!!.split(' ').map { it.toInt() }
    val M=br.readLine()!!.toInt()
    var l=0
    var r=arr.max()!!
    while (l<=r){
        val mid=(l+r)/2

        var sum=0
        for(i in 0 until n){
            sum+= min(arr[i],mid)
        }
        if(sum<=M){
            l=mid+1
        }
        else    r=mid-1
    }
    bw.write("${l-1}\n")
    bw.close()
}