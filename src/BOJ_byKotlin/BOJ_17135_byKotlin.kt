package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M, D) = br.readLine()!!.split(" ").map { it.toInt() }

    val maps = Array(N) { br.readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
    val archer = BooleanArray(M) { false }
    var res = 0

    data class Enemy(var x: Int, var y: Int, var distance: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Enemy

            if (x != other.x) return false
            if (y != other.y) return false

            return true
        }

        override fun hashCode(): Int {
            var result = x
            result = 31 * result + y
            return result
        }
    }

    fun getDistance(r1: Int, r2: Int, col1: Int, col2: Int): Int {
        return abs(r1 - r2) + abs(col1 - col2)
    }

    fun go() :Int{
        var count=0
        val deleted = HashSet<Enemy>()
        for (startRow in N - 1 downTo 0) {
            val willDeleted = HashSet<Enemy>()
            for (k in 0 until M) {
                if (!archer[k]) continue
                var closest: Enemy? = null
                for (j in 0 until M) {
                    for (i in startRow downTo 0) {
                        if (maps[i][j]==0) continue
                        val dist = getDistance(startRow+1, i,j,k)
                        if (dist <= D) {
                            if (closest == null) {
                                closest = Enemy(i,j,dist)
                            } else {
                                if (closest.distance>dist) {
                                    closest.x=i
                                    closest.y=j
                                    closest.distance=dist
                                }
                            }
                        }
                    }
                }
                if (closest!=null) {
                    willDeleted.add(closest)
                    deleted.add(closest)
                }
            }
            if (willDeleted.isNotEmpty()) {
                count+=willDeleted.size
                willDeleted.forEach { maps[it.x][it.y]=0 }
            }
        }
        deleted.forEach { maps[it.x][it.y]=1}
        return count
    }

    fun allocateArcher(nowIndex: Int, count: Int) {
        if (count == 3) {
            res= max(res, go())
            return
        }
        for (next in nowIndex + 1 until M) {
            archer[next] = true
            allocateArcher(next, count + 1)
            archer[next] = false
        }
    }

    for (i in 0 until M) {
        archer[i] = true
        allocateArcher(i, 1)
        archer[i] = false
    }
    println(res)
}