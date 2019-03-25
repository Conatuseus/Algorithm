package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (N,B,H,W)=br.readLine()!!.split(' ').map { it.toInt() }
    var res=B+1

    repeat(H){
        val p=br.readLine()!!.toInt()
        val arr=br.readLine()!!.split(' ').map { it.toInt() }
        for(a in arr){
            if(a<N) continue
            res= min(p*N,res)
        }
    }
    bw.write(if(res>B) "stay home" else "$res" +"\n")
    bw.close()
}