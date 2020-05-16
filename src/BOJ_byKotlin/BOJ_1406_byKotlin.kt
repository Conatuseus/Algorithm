package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val str=br.readLine()!!
    val M=br.readLine()!!.toInt()

    val st=Stack<Char>()
    val q=LinkedList<Char>()

    for (ch in str) {
        st.push(ch)
    }

    repeat(M) {
        val input=br.readLine()
        when(input) {
            "L" -> if (!st.isEmpty()) q.addFirst(st.pop())
            "D" -> if (!q.isEmpty()) st.push(q.poll())
            "B" -> if (!st.isEmpty()) st.pop()
            else -> st.push(input.split(" ")[1][0])
        }
    }
    println("${st.joinToString("")}${q.joinToString("")}")
}