package BOJ_byKotlin

fun main() {
    val points=Array(3){readLine()!!.split(' ').map { it.toInt() }}
    val s=(points[1][0]-points[0][0])*(points[2][1]-points[0][1])-(points[1][1]-points[0][1])*(points[2][0]-points[0][0])
    println(if(s>0) "1" else if(s<0) "-1" else "0")
}