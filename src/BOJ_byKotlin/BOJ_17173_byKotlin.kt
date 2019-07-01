package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine()!!.split(' ').map { it.toInt() }
    val arr = br.readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    var res = 0
    (1..N).forEach {
        for (num in arr) {
            if (it % num == 0) {
                res += it
                break
            }
        }
    }
    println(res)

}