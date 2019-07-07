package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (r, c) = br.readLine()!!.split(' ').map { it.toInt() }
    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(1, -1, 0, 0)

    val map = Array(r) { br.readLine()!!.toMutableList() }

    val jihunQueue = java.util.ArrayDeque<Pair<Int, Int>>()
    val fireQueue = java.util.ArrayDeque<Pair<Int, Int>>()

    for (i in 0 until r) {
        for (j in 0 until c) {
            if (map[i][j] == 'J') {
                jihunQueue.add(Pair(i, j))
            }
            if (map[i][j] == 'F') {
                fireQueue.add(Pair(i, j))
            }
        }
    }

    fun isAvail(x: Int, y: Int) = (x in 0 until r) && (y in 0 until c)
    fun isPossibleGoFire(x: Int, y: Int) = map[x][y] != 'F' && map[x][y] != '#'
    fun isOver(x: Int, y: Int) = x == 0 || y == 0 || x == r - 1 || y == c - 1
    var res = Integer.MAX_VALUE
    var count = 0
    var flag = false
    while (!flag && jihunQueue.size != 0) {

        val jihunQueueSize = jihunQueue.size
        val fireQueueSize = fireQueue.size

        count++
        repeat(fireQueueSize) {
            val (x, y) = fireQueue.poll()

            for (i in 0..3) {
                val nextX = x + dx[i]
                val nextY = y + dy[i]
                if (isAvail(nextX, nextY) && isPossibleGoFire(nextX, nextY)) {
                    map[nextX][nextY] = 'F'
                    fireQueue.add(Pair(nextX, nextY))
                }
            }

        }

        repeat(jihunQueueSize) {
            val (x, y) = jihunQueue.poll()
            if(isOver(x,y)){
                flag=true
                res= min(res,count)
            }
            for (i in 0..3) {
                val nextX = x + dx[i]
                val nextY = y + dy[i]

                if (isAvail(nextX, nextY) && map[nextX][nextY] == '.') {

                    map[nextX][nextY] = 'J'
                    jihunQueue.add(Pair(nextX, nextY))

                }
            }
        }
    }
    bw.write(if (flag) "$res\n" else "IMPOSSIBLE\n")
    bw.close()
}