package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val fir=HashMap<Int,Int>()
    val firWinnerPrice= intArrayOf(500,300,200,50,30,10)
    for(i in 1..6){
        for(j in 1..i){
            fir[(i-1)*i/2+j]=firWinnerPrice[i-1]
        }
    }
    val sec=HashMap<Int,Int>()
    val secWinnerPrice= intArrayOf(512,256,128,64,32)
    for(i in 1..5){
        for(j in Math.pow(2.0,(i-1).toDouble()).toInt() until Math.pow(2.0,i.toDouble()).toInt()){
            sec[j]=secWinnerPrice[i-1]
        }
    }
    val t=br.readLine()!!.toInt()
    println(fir.toList().joinToString(" "))
    println(sec.toList().joinToString(" "))
    repeat(t){
        val (f,s)=br.readLine()!!.split(' ').map { it.toInt() }
        var sum=if(fir.containsKey(f)) fir[f]!! else 0
        sum+=if(sec.containsKey(s)) sec[s]!! else 0
        bw.write("${sum*10000}\n")
    }
    bw.close()
}