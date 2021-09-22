package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N,M) = br.readLine()!!.split(" ").map { it.toInt() }
    val participants = Array(N+1) { mutableListOf<String>() }

    while (true) {
        val (numStr, name) = br.readLine()!!.split(" ")
        val num = numStr.toInt()

        if (num == 0)
            break

        if (participants[num].size >= M) continue
        participants[num].add(name)
    }

    for (i in 1..N step 2) {
        if (participants[i].size == 0) continue
        participants[i].sortedWith(compareBy({it.length}, {it})).forEach {
            println("$i $it")
        }
    }
    for (i in 2..N step 2) {
        if (participants[i].size == 0) continue
        participants[i].sortedWith(compareBy({it.length}, {it})).forEach {
            println("$i $it")
        }
    }
}
