package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (N,M)=br.readLine()!!.split(' ').map { it.toInt() }
    val pq=PriorityQueue<Long>(kotlin.Comparator { o1, o2 -> o1.compareTo(o2)  })
    val input=br.readLine()!!.split(' ').map { it.toLong() }
    input.forEach { pq.add(it) }

    repeat(M){
        val f=pq.poll()
        val s=pq.poll()
        pq.add(f+s)
        pq.add(f+s)
    }

    bw.write("${pq.sum()}\n")
    bw.close()
}