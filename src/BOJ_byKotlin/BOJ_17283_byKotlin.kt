package BOJ_byKotlin

fun main() {
    var L= readLine()!!.toInt()
    val R= readLine()!!.toDouble()

    var res=0
    var mul=2
    L = (L*(R / 100)).toInt()
    while (L>5){
        res+=L*mul
        mul*=2
        L = (L*(R / 100)).toInt()
    }
    println(res)
}