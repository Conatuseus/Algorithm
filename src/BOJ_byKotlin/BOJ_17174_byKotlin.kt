package BOJ_byKotlin

fun main() {
    val (n,m)= readLine()!!.split(' ').map { it.toInt() }

    var res=n
    var count=n
    while (count!=0){
        res+=count/m
        count/=m
    }
    println(res)
}