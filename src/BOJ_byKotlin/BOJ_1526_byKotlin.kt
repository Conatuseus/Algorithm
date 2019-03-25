package BOJ_byKotlin

import kotlin.math.max

fun main(args: Array<String>) {
    val n= readLine()!!.toInt()
    val q=java.util.ArrayDeque<Int>()
    q.add(4)
    if(n>=7) q.add(7)
    var res=4
    while (!q.isEmpty()){
        val here=q.poll()
        res= max(res,here)
        if(here*10+4<=n){
            q.add(here*10+4)
        }
        if(here*10+7<=n){
            q.add(here*10+7)
        }
    }
    println(res)
}