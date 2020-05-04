package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val n=br.readLine()!!.toInt()
    val sb=StringBuilder()
    println((1 shl n)-1)

    fun hanoi(num:Int,a:Int,b:Int,c:Int) {
        if (num==1) {
            sb.append("$a $c\n")
            return
        }
        hanoi(num-1, a,c,b)
        sb.append("$a $c\n")
        hanoi(num-1, b,a,c)
    }
    hanoi(n,1,2,3)
    print(sb.toString())
}