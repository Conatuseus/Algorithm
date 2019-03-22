package BOJ_byKotlin

fun main(args: Array<String>) {
    val (n,m)= readLine()!!.split(' ').map { it.toInt() }
    val res=IntArray(m)
    fun go(i:Int,size:Int){
        res[size-1]=i
        if(size==m) println(res.joinToString(" "))
        else{
            for(next in i+1..n) go(next,size+1)
        }
    }
    for(i in 1..n)  go(i,1)
}