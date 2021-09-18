package BOJ_byKotlin

import kotlin.math.min

fun main() {
    fun madeNum(input: List<Int>) = input[0]*1000 + input[1]*100 + input[2]*10 + input[3]

    fun clockNum(num: Int): Int {
        var tmp = num
        var res = num
        repeat(3) {
            tmp = tmp%1000*10 + tmp/1000
            res = min(res, tmp)
        }
        return res
    }

    val input = readLine()!!.split(' ').map { it.toInt() }
    val minValue = clockNum(madeNum(input))
    var count = 0

    for (i in 1111..minValue) {
        if (clockNum(i) == i) count++
    }
    println(count)
}