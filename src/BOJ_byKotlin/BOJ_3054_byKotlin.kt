package BOJ_byKotlin

fun main(args: Array<String>) {
    val str= readLine()!!
    val map=Array(5){CharArray(4*str.length+1){'.'}}

    fun fillMap(y:Int,type:Int){
        map[2][y-2]=if(type==0&&map[2][y-2]!='*') '#' else '*'
        map[2][y+2]=if(type==0) '#' else '*'
        map[1][y-1]=if(type==0) '#' else '*'
        map[1][y+1]=if(type==0) '#' else '*'
        map[0][y]=if(type==0) '#' else '*'
        map[3][y-1]=if(type==0) '#' else '*'
        map[3][y+1]=if(type==0) '#' else '*'
        map[4][y]=if(type==0) '#' else '*'
    }
    for(i in 0 until str.length){
        val y=4*i+2
        map[2][y]=str[i]
        if((i+1)%3==0){
            fillMap(y,1)
        }
        else{
            fillMap(y,0)
        }
    }
    for(i in 0 until 5)  {
        map[i].forEach { print(it) }
        println()
    }
}