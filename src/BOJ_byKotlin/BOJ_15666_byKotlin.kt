package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (n,m)=br.readLine()!!.split(' ').map { it.toInt() }
    val num=br.readLine()!!.split(' ').map { it.toInt() }.toSet().sorted()
    val size=num.size
    val res=IntArray(m)
    fun go(here:Int, count:Int){
        if(count==m)    bw.write("${res.toList().joinToString(" ")}\n")
        else {
            for (i in here until size) {
                res[count] = num[i]
                go(i, count + 1)
            }
        }
    }
    go(0,0)
    bw.close()
}