package BOJ_byKotlin

fun main(args: Array<String>) {
    val (n,m,l)= readLine()!!.split(' ').map { it.toInt() }
    var now=1
    val catchCount=IntArray(n+1)
    var res=0

    catchCount[now]++
    while (catchCount[now]!=m){
        if(catchCount[now]%2==0){
            now+=n-l
            now%=n
        }
        else{
            now+=l
            now%=n
        }
        catchCount[now]++
        res++
    }
    println(res)
}