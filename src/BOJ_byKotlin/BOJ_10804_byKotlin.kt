package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))
    val num=IntArray(20){it+1}

    fun swap(x:Int,y:Int){
        val tmp=num[x]
        num[x]=num[y]
        num[y]=tmp
    }
    fun rev(x:Int,y:Int){
        for(i in 0..(x+y)/2-x)
            swap(x+i,y-i)
    }

    repeat(10){
        val (s,e)=br.readLine()!!.split(' ').map { it.toInt()-1 }
        rev(s,e)
    }
    bw.write(num.toList().joinToString(" ")+"\n")
    bw.close()
}