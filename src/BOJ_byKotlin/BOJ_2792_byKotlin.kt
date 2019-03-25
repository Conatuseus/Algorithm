package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br= BufferedReader(InputStreamReader(System.`in`))
    val (n,m)=br.readLine()!!.split(' ').map { it.toInt() }
    val arr=IntArray(m){br.readLine()!!.toInt()}.sorted()
    val max=arr.max()!!

    var l=0
    var r=max
    while (l<r){
        val mid=(l+r)/2
        if(arr.sumBy { (it-1)/mid+1 }<=n)
            r=mid
        else   l=mid+1
    }
    println(l)
}