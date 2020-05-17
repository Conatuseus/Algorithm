package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (U,N)=br.readLine()!!.split(" ").map { it.toInt() }

    val map=HashMap<Int,Pair<String,Int>>()
    repeat(N) {
        val (name, costStr)=br.readLine()!!.split(" ")
        val cost=costStr.toInt()
        if (cost<=U) {
            if (map.containsKey(cost)) {
                map[cost]=Pair(map[cost]!!.first, map[cost]!!.second+1)
            }
            else {
                map[cost]=Pair(name, 1)
            }
        }
    }
    val minNum=map.minBy { it.value.second }!!.value.second
    val res=map.filterValues { it.second==minNum }.minBy { it.key }
    println("${res!!.value.first} ${res.key}")
}