package BOJ_byKotlin

fun main() {

    repeat(readLine()!!.toInt()){
        val n= readLine()!!.toInt()
        var res=0L
        for (i in 0 until n){
            res= ((res+0.5)*2).toLong()
        }
        println(res)
    }
}