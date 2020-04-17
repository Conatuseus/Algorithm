package BOJ_byKotlin

fun main() {
    val x= readLine()!!.toInt()
    val y= readLine()!!.toInt()
    println(if (x>0&&y>0) 1 else if (x<0&&y>0) 2 else if (x<0&&y<0) 3 else 4)
}