package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (N,C)=br.readLine()!!.split(' ').map { it.toInt() }
    val M=br.readLine()!!.toInt()

    data class Triple(val s:Int,val e:Int,val box:Int):Comparable<Triple>{
        override fun compareTo(o: Triple): Int {
            if(this.e!=o.e) return this.e-o.e
            return this.s-o.s
        }
    }

    val arr=Array(M){ val a=br.readLine()!!.split(' ').map { it.toInt() }
    Triple(a[0],a[1],a[2])}.sorted()
    val ing=IntArray(N+1)
    var res=0
    for(i in 0 until M){
        val (start,end,w)=arr[i]

        val maxWeight=ing.filterIndexed { index, _ -> index in start until end }.max()!!
        if(maxWeight==C)    continue
        var possibleW=w
        if(maxWeight+w>=C){
            possibleW=C-maxWeight
            res+=possibleW
        }
        else    res+=w
        for(i in start until end)   ing[i]+=possibleW
    }
    bw.write("$res\n")
    bw.close()
}