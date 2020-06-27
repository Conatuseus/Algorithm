package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))

    repeat(br.readLine()!!.toInt()) {
        val (n,type) = br.readLine()!!.split(" ")
        if (type=="C") {
            val arr=br.readLine()!!.split(" ").map { it.toCharArray()[0] }
            println(arr.map { it.toInt()-64 }.joinToString(" "))
        }
        else {
            val arr=br.readLine()!!.split(" ").map { it.toInt()+64 }
            println(arr.map { it.toChar() }.joinToString(" "))
        }
    }
}