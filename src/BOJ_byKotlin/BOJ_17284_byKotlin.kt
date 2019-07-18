package BOJ_byKotlin

fun main() {
    val str= readLine()!!.split(' ').map { it.toInt() }
    var res=5000
    for (i in 0 until str.size){
        res-=when(str[i]){
            1-> 500
            2-> 800
            else -> 1000
        }
    }
    println(res)
}