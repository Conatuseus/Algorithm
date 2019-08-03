package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    fun isPrime(num:Int):Boolean{
        if(num==0||num==1)  return false
        for (i in 2 .. sqrt(num.toDouble()).toInt()){
            if(num%i==0){
                return false
            }
        }
        return true
    }

    repeat(br.readLine()!!.toInt()){
        val num=br.readLine()
        val numCount=IntArray(10)
        var res=0
        num.forEach { numCount[(it-'0')]++ }

        fun go(now:Int,size:Int){
            if(size==num.length){
                if(isPrime(now))    res++
            }
            if(size<num.length){
                if(isPrime(now)) res++
                for (i in 0 until 10){
                    if(numCount[i]>0){
                        val next=now*10+i
                        numCount[i]--
                        go(next,size+1)
                        numCount[i]++
                    }
                }
            }
        }
        for (i in 1 until 10){
            if(numCount[i]>0){
                numCount[i]--
                go(i,1)
                numCount[i]++
            }
        }
        bw.write("$res\n")
    }
    bw.close()
}