package BOJ_byKotlin

fun main() { println(5000-readLine()!!.split(' ').map{if(it=="1") 500 else if(it=="2") 800 else 1000 }.sum()) }