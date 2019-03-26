package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (N,K)=br.readLine()!!.split(' ').map { it.toInt() }
    data class Pair(var boy:Int,var girl:Int)
    val student=Array(7){Pair(0,0)}

    repeat(N){
        val (S,Y)=br.readLine()!!.split(' ').map { it.toInt() }
        if(S==0)    student[Y].girl++
        else    student[Y].boy++
    }

    var res=0
    for(i in 1..5 step 2){
        if(i==1){
            val sum=student[i].boy+student[i].girl+student[i+1].boy+student[i+1].girl
            res+=if(sum%K==0)  sum/K else (sum/K)+1
        }
        else{
            val boySum=student[i].boy+student[i+1].boy
            val girlSum=student[i].girl+student[i+1].girl
            res+=if(boySum%K==0)    boySum/K    else (boySum/K)+1
            res+=if(girlSum%K==0)   girlSum/K   else  (girlSum/K)+1
        }
    }
    bw.write("$res\n")
    bw.close()
}