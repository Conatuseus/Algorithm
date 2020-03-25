package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val len = br.readLine()!!.toInt()
    val sik = br.readLine()

    val calNum = len / 2
    var res = Int.MIN_VALUE

    val num = sik.filter { it in '0'..'9' }.map { it-'0' }.toIntArray()
    val calculator = sik.filter { it !in '0'..'9' }.toCharArray()

    fun cal(a:Int,b:Int,calculator:Char):Int {
        return when(calculator) {
            '+' -> a+b
            '-' -> a-b
            else -> a*b
        }
    }

    fun go(nowIndex: Int, nowValue: Int) {
        if (nowIndex>=num.size) {
            res= max(nowValue, res)
            return
        }

        if (nowIndex==0) {
            go(nowIndex+2, cal(num[0],num[1],calculator[0]))

            if (nowIndex+2<num.size) {
                val pre=cal(num[1],num[2],calculator[1])
                go(nowIndex+3, cal(num[0],pre,calculator[0]))
            }
        }
        else {
            go(nowIndex+1, cal(nowValue, num[nowIndex], calculator[nowIndex-1]))

            if (nowIndex+1<num.size) {
                val pre=cal(num[nowIndex],num[nowIndex+1],calculator[nowIndex])
                go(nowIndex+2, cal(nowValue,pre,calculator[nowIndex-1]))
            }
        }
    }
    if (len!=1) go(0,0)
    else res=num[0]
    println(res)
}
