package BOJ_byKotlin

fun main(args: Array<String>) {
    val (n,m)= readLine()!!.split(' ').map { it.toInt() }

    val res=IntArray(m)
    fun go(i:Int,s:Int){
        res[s-1]=i
        if(s==m){
            println(res.joinToString(" "))
        }
        else {
            for (next in i..n) {
                go(next, s + 1)
            }
        }
    }
    for(i in 1..n)  go(i,1)

}