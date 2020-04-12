package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arr = Array(9) { br.readLine()!!.toInt() }

    for (i in 0 until 9) {
        for (j in i + 1 until 9) {
            val filterIndexed = arr.filterIndexed { index, _ -> index != i && index != j }
            if (filterIndexed.sum() == 100) {
                filterIndexed.forEach { println(it) }
            }
        }
    }
}