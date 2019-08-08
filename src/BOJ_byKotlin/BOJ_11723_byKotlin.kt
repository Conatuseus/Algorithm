package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val s=BooleanArray(21)
    repeat(br.readLine()!!.toInt()){
        when (val input=br.readLine()!!) {
            "all" -> s.fill(true)
            "empty" -> s.fill(false)
            else -> {
                val (order,num)=input.split(' ')
                when(order){
                    "add" -> s[num.toInt()]=true
                    "check" -> bw.write("${if(s[num.toInt()]) 1 else 0}\n")
                    "remove" -> s[num.toInt()]=false
                    "toggle" -> s[num.toInt()]=!s[num.toInt()]
                }
            }
        }
    }
    bw.close()
}