package BOJ_byKotlin

fun main(args: Array<String>) {
    val n= readLine()!!.toInt()
    val q=java.util.ArrayDeque<Int>()
    repeat(n){
        q.add(it+1)
    }
    var res=1
    while(!q.isEmpty()){
        res=q.poll()
        if(!q.isEmpty()) {
            q.add(q.poll())
        }
    }
    println(res)
}