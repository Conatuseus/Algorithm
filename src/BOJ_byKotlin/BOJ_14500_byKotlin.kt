package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (N,M)=br.readLine()!!.split(' ').map { it.toInt() }
    val matrix = Array(N) { br.readLine()!!.split(' ').map { it.toInt() } }


    fun fun1(x: Int, y: Int): Int {
        if (y + 3 < M) {
            return (y..y + 3).sumBy { matrix[x][it] }
        }
        return 0
    }

    fun fun2(x: Int, y: Int): Int {
        if (x + 3 < N) {
            return (x..x + 3).sumBy { matrix[it][y] }
        }
        return 0
    }

    fun fun3(x: Int, y: Int): Int {
        if (x + 1 < N && y + 1 < M) {
            return matrix[x][y + 1] + matrix[x][y] + matrix[x + 1][y] + matrix[x + 1][y + 1]
        }
        return 0
    }

    fun fun4(x: Int, y: Int): Int {
        if (x-2>=0) {
            if(y-1>=0 || y+1<M)
                return (x-2..x).sumBy { matrix[it][y] } + if(y>=1&&y<M-1) max(matrix[x][y-1], matrix[x][y+1]) else if(y>=1) matrix[x][y-1] else matrix[x][y+1]
        }
        return 0
    }

    fun fun5(x: Int, y: Int): Int {
        if (x - 1 >= 0 && y + 2 < M) {
            return (y..y + 2).sumBy { matrix[x][it] } + max(matrix[x - 1][y + 2],matrix[x-1][y])
        }
        return 0
    }

    fun fun6(x: Int, y: Int): Int {
        if (x + 2 < N) {
            if(y-1>=0 || y+1<M)
              return (x..x + 2).sumBy { matrix[it][y] } + if(y>=1&&y+1<M) max(matrix[x][y-1],matrix[x][y+1]) else if(y>=1)  matrix[x][y-1] else matrix[x][y+1]
        }
        return 0
    }

    fun fun7(x: Int, y: Int): Int {
        if (x + 1 < N && y + 2 < M) {
            return (y..y + 2).sumBy { matrix[x][it] } + max(matrix[x + 1][y],matrix[x+1][y+2])
        }
        return 0
    }

    fun fun8(x: Int, y: Int): Int {
        if (x + 2 < N && y + 1 < M) {
            return (x..x + 2).sumBy { matrix[it][y] + matrix[it][y + 1] } - min(matrix[x][y + 1] + matrix[x + 2][y],matrix[x][y]+matrix[x+2][y+1])
        }
        return 0
    }

    fun fun9(x: Int, y: Int): Int {
        if (x - 1 >= 0 && y + 2 < M) {
            return (y..y + 2).sumBy { matrix[x - 1][it] + matrix[x][it] } - min(matrix[x - 1][y] + matrix[x][y + 2], matrix[x][y]+matrix[x-1][y+2])
        }
        return 0
    }

    fun fun10(x: Int, y: Int): Int {
        if (x + 1 < N && y + 2 < M) {
            return (y..y + 2).sumBy { matrix[x][it] } + matrix[x + 1][y + 1]
        }
        return 0
    }

    fun fun11(x: Int, y: Int): Int {
        if (x + 2 < N && y - 1 >= 0) {
            return (x..x + 2).sumBy { matrix[it][y] } + matrix[x + 1][y - 1]
        }
        return 0
    }

    fun fun12(x: Int, y: Int): Int {
        if (x - 1 >= 0 && y + 2 < M) {
            return (y..y + 2).sumBy { matrix[x][it] } + matrix[x - 1][y + 1]
        }
        return 0
    }

    fun fun13(x: Int, y: Int): Int {
        if (x + 2 < N && y + 1 < M) {
            return (x..x + 2).sumBy { matrix[it][y] } + matrix[x + 1][y + 1]
        }
        return 0
    }

    fun getMax(x: Int, y: Int): Int {
        var ret = 0
        ret = max(ret, fun1(x, y))
        ret = max(ret, fun2(x, y))
        ret = max(ret, fun3(x, y))
        ret = max(ret, fun4(x, y))
        ret = max(ret, fun5(x, y))
        ret = max(ret, fun6(x, y))
        ret = max(ret, fun7(x, y))
        ret = max(ret, fun8(x, y))
        ret = max(ret, fun9(x, y))
        ret = max(ret, fun10(x, y))
        ret = max(ret, fun11(x, y))
        ret = max(ret, fun12(x, y))
        ret = max(ret, fun13(x, y))
        return ret
    }

    var res = 0
    for (i in 0 until N) {
        for (j in 0 until M) {
            res = max(res, getMax(i, j))
        }
    }
    bw.write("$res\n")

    bw.close()
}