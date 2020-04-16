package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (N,P)=br.readLine()!!.split(" ").map { it.toInt() }
    val stacks=List(7){Stack<Int>()}
    var res=0
    repeat(N) {
        val (line, sound) = br.readLine()!!.split(" ").map { it.toInt() }
        if (stacks[line].isEmpty()) {
            stacks[line].push(sound)
            res++
        }
        else {
            while (!stacks[line].isEmpty()&&stacks[line].peek()>sound) {
                stacks[line].pop()
                res++
            }
            if (stacks[line].isEmpty()||stacks[line].peek()!=sound) {
                stacks[line].push(sound)
                res++
            }
        }
    }
    println(res)
}