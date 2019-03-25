package BOJ_byKotlin

fun main() {
    repeat(readLine()!!.toInt()){
        val arr= readLine()!!.split(' ').map { it.toInt() }.filter { it%2==0 }
        println("${arr.sum()} ${arr.min()}")
    }
}