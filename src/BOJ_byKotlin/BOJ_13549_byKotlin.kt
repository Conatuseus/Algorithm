package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val visit = BooleanArray(200001)
    val (N, K) = br.readLine()!!.split(' ').map { it.toInt() }
    if (K <= N) {
        bw.write("${N - K}\n")
    } else {
        val q = java.util.ArrayDeque<Pair<Int, Int>>()
        q.add(Pair(N, 0))
        visit[N] = true
        while (!q.isEmpty()) {
            val (loc, dist) = q.poll()
            if (loc == K) {
                bw.write("$dist\n")
                break
            }
            if (loc * 2 <= 200000 && !visit[loc * 2]) {
                visit[loc * 2] = true
                q.add(Pair(loc * 2, dist))
            }
            if (loc - 1 >= 0 && !visit[loc - 1]) {
                visit[loc - 1] = true
                q.add(Pair(loc - 1, dist + 1))
            }
            if (loc + 1 <= 200000 && !visit[loc + 1]) {
                visit[loc + 1] = true
                q.add(Pair(loc + 1, dist + 1))
            }
        }
    }
    bw.close()
}