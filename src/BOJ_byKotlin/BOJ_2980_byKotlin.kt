package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (n,l)=br.readLine()!!.split(' ').map { it.toInt() }
    val trafficLight=Array(n){ val (d,r,g)=br.readLine()!!.split(' ').map { it.toInt() }
        Triple(d,r,g)}

    var res=0

    for(i in 0 until n){
        res += if(i==0) trafficLight[0].first
                else trafficLight[i].first-trafficLight[i-1].first
        if(res%(trafficLight[i].second+trafficLight[i].third)<trafficLight[i].second){
            res+=trafficLight[i].second-res%(trafficLight[i].second+trafficLight[i].third)
        }
    }
    res+=l-trafficLight[n-1].first
    bw.write("$res\n")
    bw.close()
}