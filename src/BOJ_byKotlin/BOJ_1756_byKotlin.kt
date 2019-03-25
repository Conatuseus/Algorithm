package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (d,n)=br.readLine()!!.split(' ').map { it.toInt() }
    val oven=br.readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    val pizza=br.readLine()!!.split(' ').map { it.toInt() }.toIntArray()

    val possibleSize=IntArray(d)
    possibleSize[0]=oven[0]
    for(i in 1 until d){
        possibleSize[i]= min(possibleSize[i-1],oven[i])
    }

    var res=0
    var pizzaIdx=0
    for(i in d-1 downTo 0){
        if(possibleSize[i]>=pizza[pizzaIdx]){
            pizzaIdx++
        }
        if(pizzaIdx==n){
            res=i+1
            break
        }
    }
    bw.write("$res\n")
    bw.close()
}