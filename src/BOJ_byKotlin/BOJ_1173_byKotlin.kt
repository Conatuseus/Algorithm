package BOJ_byKotlin

fun main(args: Array<String>) {
    val (n,start,max,plus,minus)= readLine()!!.split(' ').map { it.toInt() }
    var now=start
    var res=0
    var exerCount=0
    while (true){
        if(now+plus<=max){
            now+=plus
            res++
            exerCount++
        }
        else{
            now-=minus
            res++
        }
        if(now<start){
            if(start+plus>max){
                res=-1
                break
            }
            now=start
        }
        if(exerCount==n)    break
    }
    println(res)
}