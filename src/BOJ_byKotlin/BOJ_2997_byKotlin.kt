package BOJ_byKotlin

fun main() {
    val num= readLine()!!.split(' ').map { it.toInt() }.sorted()
    if(num[1]-num[0]==2*(num[2]-num[1]))
        println(num[0]+num[2]-num[1])
    else if(2*(num[1]-num[0])==num[2]-num[1]){
        println(num[1]+num[1]-num[0])
    }
    else if(num[1]-num[0]==num[2]-num[1]){
        if(num[2]*2-num[1]<=100){
            println(num[2]*2-num[1])
        }
        else{
            println(num[0]*2-num[1])
        }
    }
}