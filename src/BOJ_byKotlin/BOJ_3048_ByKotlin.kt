package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (firSize,secSize)=br.readLine()!!.split(' ').map { it.toInt() }
    val fir=br.readLine()!!.reversed().toCharArray()
    val sec=br.readLine()!!.toCharArray()
    val t=br.readLine()!!.toInt()
    val size=firSize+secSize
    val arr=IntArray(size){ if(it<firSize) 1 else -1}

    repeat(t){
        var i=0
        while (i<size-1){
            if(arr[i]==1&&arr[i+1]==-1){
                arr[i]*=-1
                arr[i+1]*=-1
                i++
            }
            i++
        }
    }
    var firIdx=0
    var secIdx=0
    for(i in 0 until size)
        bw.write(if(arr[i]==1)"${fir[firIdx++]}" else "${sec[secIdx++]}")
    bw.write("\n")
    bw.close()
}