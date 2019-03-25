package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val size=br.readLine()!!.toInt()
    val arr=IntArray(size)

    val pNum=br.readLine()!!.toInt()
    val firstRes=IntArray(pNum)
    val secRes=IntArray(pNum)
    repeat(pNum){
        val (s,e)=br.readLine()!!.split(' ').map { it.toInt()-1 }
        firstRes[it]=e-s+1
        for(i in s..e){
            if(arr[i]==0){
                arr[i]=it+1
                secRes[it]++
            }
        }
    }
    for(i in 0 until pNum){
        if(firstRes[i]==firstRes.max()) {
            bw.write("${i+1}\n")
            break
        }
    }
    for(i in 0 until pNum){
        if(secRes[i]==secRes.max()){
            bw.write("${i+1}\n")
            break
        }
    }
    bw.close()
}