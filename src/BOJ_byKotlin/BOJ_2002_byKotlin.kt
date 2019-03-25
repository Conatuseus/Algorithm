package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))


    val n=br.readLine()!!.toInt()
    val hs=HashMap<String,Boolean>()
    val q1=java.util.ArrayDeque<String>()
    val q2=java.util.ArrayDeque<String>()
    repeat(2*n){
        if(it<n)    q1.add(br.readLine()!!)
        else    q2.add(br.readLine()!!)
    }

    var res=0
    while (!q1.isEmpty()&&!q2.isEmpty()){
        if(q1.first!=q2.first){
            if(hs[q1.first]==true){
               q1.poll()
            }
            else {
                res++
                hs[q2.poll()] = true
            }
        }
        else{
            q1.poll()
            q2.poll()
        }
    }
    bw.write("$res\n")
    bw.close()
}