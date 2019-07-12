package BOJ_byKotlin

fun main()= repeat(readLine()!!.toInt()) {
    val (a, b) = readLine()!!.split(' ').map { it.toBigInteger(2) }
    println(a.add(b).toString(2))
}