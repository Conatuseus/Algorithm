package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))

    val n=br.readLine()!!.toInt()
    val arr=br.readLine()!!.split(" ").map { it.toInt()}

    val stack=Stack<Pair<Int,Int>>()
    val res=IntArray(n)

    for (i in arr.indices) {
        if (stack.isEmpty()) {
            stack.push(Pair(i, arr[i]))
            continue
        }
        val last = stack.peek()
        if (last.second>=arr[i]) {
            stack.push(Pair(i,arr[i]))
            res[i] = last.first+1
        }
        else {
            while (!stack.isEmpty()&&stack.peek().second<arr[i]) {
                stack.pop()
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek().first+1
            }
            stack.push(Pair(i,arr[i]))
        }
    }
    println(res.joinToString(" "))
}