package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val pq=PriorityQueue<Long>()
    repeat(br.readLine()!!.toInt()){
        val order=br.readLine()!!.toLong()
        when(order) {
            0L -> if(pq.isEmpty()) {
                bw.write("0\n")
            }
            else{
                bw.write("${pq.poll()}\n")
            }
            else -> pq.add(order)
        }
    }
    bw.close()
}