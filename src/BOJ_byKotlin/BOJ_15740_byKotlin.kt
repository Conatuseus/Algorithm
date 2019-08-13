package BOJ_byKotlin


fun main(){
    val (a,b)= readLine()!!.split(' ').map { it.toBigInteger() }
    println(a.add(b))
}