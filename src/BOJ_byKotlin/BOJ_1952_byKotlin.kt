package BOJ_byKotlin

fun main(args: Array<String>) {
    val (r,c)= readLine()!!.split(' ').map { it.toInt() }
    val map=Array(r){IntArray(c)}
    val dx= arrayOf(0,1,0,-1)
    val dy= arrayOf(1,0,-1,0)
    var res=0
    var count=1

    fun go(x:Int,y:Int,dir:Int){
        map[x][y]=count++
        val bx=x+dx[dir]
        val by=y+dy[dir]
        if(bx in 0 until r && by in 0 until c && map[bx][by]==0){
            go(bx, by, dir)
        }
        else{
            res++
            if(map[x+dx[(dir+1)%4]][y+dy[(dir+1)%4]]==0)
               go(x+dx[(dir+1)%4],y+dy[(dir+1)%4],(dir+1)%4)
        }
    }
    map[0][0]=1
    go(0,0,0)
    println(res-1)
}
//fun main(args: Array<String>) {
//    fun go(n: Int, m: Int): Int = when {
//        n == 1 -> 0
//        m == 1 -> 1
//        n == 2 -> 2
//        m == 2 -> 3
//        else -> 4 + go(n - 2, m - 2)
//    }
//    val (M, N) = readLine()!!.split(" ").map{ it.toInt() }
//    println(go(M, N))
//}