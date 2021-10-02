package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))

    val n=br.readLine()!!.toInt()
    val queue = mutableListOf<Pair<String, Int>>()
    val waiting = Stack<Pair<String, Int>>()

    repeat(n) {
        br.readLine()!!.split(" ").forEach { fullName->
            val (str,num)=fullName.split("-")
            queue.add(Pair(str,num.toInt()))
        }
    }

    var res=true
    val sorted = queue.sortedWith(compareBy({it.first}, {it.second})).toMutableList()
    while (sorted.isNotEmpty()) {
        if (waiting.isNotEmpty() && waiting.peek() == sorted.first()) {
            waiting.pop()
            sorted.removeAt(0)
        }
        else if (queue.isNotEmpty() && queue.first() == sorted.first()) {
            queue.removeAt(0)
            sorted.removeAt(0)
        }
        else {
            if (queue.isNotEmpty()) {
                waiting.push(queue.removeAt(0))
                continue
            }
            println("BAD")
            res=false
            break
        }
    }
    if (res) println("GOOD")
}