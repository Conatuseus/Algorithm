package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val deque=ArrayDeque<Int>()
    repeat(br.readLine()!!.toInt()){
        val st=StringTokenizer(br.readLine()!!.trim())
        val order=st.nextToken()
        when(order){
            "push_front" -> deque.addFirst(st.nextToken()!!.toInt())
            "push_back" -> deque.addLast(st.nextToken()!!.toInt())
            "pop_front" -> {
                var num=-1
                if (!deque.isEmpty()) {
                    num=deque.poll()
                }
                bw.write("$num\n")
            }
            "pop_back" -> {
                var num=-1
                if(!deque.isEmpty()){
                    num=deque.pollLast()!!
                }
                bw.write("$num\n")
            }
            "size" -> bw.write("${deque.size}\n")
            "empty" -> bw.write(if(deque.isEmpty()) "1\n" else "0\n")
            "front" -> bw.write(if(deque.isEmpty()) "-1\n" else "${deque.first}\n")
            "back" -> bw.write(if(deque.isEmpty()) "-1\n" else "${deque.last}\n")
        }
    }
    bw.close()
}