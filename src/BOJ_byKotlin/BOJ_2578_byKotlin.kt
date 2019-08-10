package BOJ_byKotlin

fun main() {
    val bingo=Array(5){ readLine()!!.split(' ').map { it.toInt() }.toIntArray()}

    val num= mutableListOf<Int>()
    repeat(5){
        readLine()!!.split(' ').map { it.toInt() }.forEach { num.add(it) }
    }

    fun isOver():Boolean{
        var resCount=0
        bingo.forEach { if(it.sum()==0) resCount++ }
        for (i in 0 until 5){
            var sum=0
            for (j in 0 until 5){
                sum+=bingo[j][i]
            }
            if(sum==0)  resCount++
        }
        var leftToRight=0
        var rightToLeft=0
        for (i in 0 until 5){
            leftToRight+=bingo[i][i]
            rightToLeft+=bingo[4-i][i]
        }
        if(leftToRight==0) resCount++
        if(rightToLeft==0) resCount++
        return resCount>=3
    }
    for (i in 0 until 25){
        for (p in 0 until 5){
            for(q in 0 until 5){
                if(bingo[p][q]==num[i]){
                    bingo[p][q]=0
                }
            }
        }
        if(isOver()){
            println("${i+1}")
            break
        }
    }
}