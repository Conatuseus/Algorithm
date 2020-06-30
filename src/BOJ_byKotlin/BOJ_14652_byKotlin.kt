package BOJ_byKotlin

fun main() {
    val (n,m,k)= readLine()!!.split(" ").map { it.toInt() }
    println("${k/m} ${k%m}")
}