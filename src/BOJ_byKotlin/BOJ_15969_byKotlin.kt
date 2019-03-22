package BOJ_byKotlin


fun main(){
    readLine()!!
    println(readLine()!!.split(' ').map { it.toInt() }.let { it.max()!!.minus(it.min()!!) })
}