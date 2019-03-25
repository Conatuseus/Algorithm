package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val n=br.readLine()!!.toInt()
    val arr=br.readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    val chk=BooleanArray(400001)

    var res=0
    for(i in 0 until n){
        for(j in 0 until i){
            if(chk[arr[i]-arr[j]+200000]){
                res++
                break
            }
        }
        for(j in 0..i){
            chk[arr[i]+arr[j]+200000]=true
        }
    }
    bw.write("$res\n")
    bw.close()
}