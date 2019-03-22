package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    data class Pair(val start:Int,val end:Int):Comparable<Pair>{
        override fun compareTo(other: Pair): Int {
            if(this.start!=other.start) return this.start-other.start
            return other.end-this.end
        }
    }
    val N=br.readLine()!!.toInt()
    val M=br.readLine()!!.toInt()
    val bus=Array(M){ val (s,e)=br.readLine()!!.split(' ').map { it.toInt() }
    Pair(Pair(if(s>e) s else s+N, e+N ), it+1)}.sortedBy { it.first }

    val res= mutableListOf<Int>()

    val firstStart=bus[0].first.start
    var nowEnd=0
    for(b in bus){
        val start=b.first.start
        val end=b.first.end
        val index=b.second
        if(start>=N&&start-N>=firstStart)   continue
        if(end>nowEnd){
            res.add(index)
            nowEnd=end
        }
    }
    bw.write(res.sorted().joinToString(" "))
    bw.close()
}