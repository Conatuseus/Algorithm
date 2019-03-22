package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val wheel=Array(4){br.readLine()!!.toCharArray()}

    fun turnWheel(idx:Int,direction:Int){   // 휠 번호: idx, 방향: direction 1이면 시계 -1이면 반시계
        if(direction==1){
            val tmp=wheel[idx][7]
            for(i in 7 downTo 1){
                wheel[idx][i]=wheel[idx][i-1]
            }
            wheel[idx][0]=tmp
        }
        else{
            val tmp=wheel[idx][0]
            for(i in 0..6){
                wheel[idx][i]=wheel[idx][i+1]
            }
            wheel[idx][7]=tmp
        }
    }

    repeat(br.readLine()!!.toInt()){
        var (num,dir)=br.readLine()!!.split(' ').map { it.toInt() }
        num-=1

        val turnIsPossible=BooleanArray(4)
        turnIsPossible[num]=true

        for(i in num+1 until 4){
            if(wheel[i-1][2]!=wheel[i][6]){
                turnIsPossible[i]=true
            }
            else break
        }
        for(i in num-1 downTo 0){
            if(wheel[i][2]!=wheel[i+1][6]){
                turnIsPossible[i]=true
            }
            else break
        }
        turnWheel(num,dir)
        var turnDir=dir*-1
        for(i in num+1 until 4){
            if(turnIsPossible[i]){
                turnWheel(i,turnDir)
                turnDir*=-1
            }
            else    break
        }
        turnDir=dir*-1
        for(i in num-1 downTo 0){
            if(turnIsPossible[i]){
                turnWheel(i,turnDir)
                turnDir*=-1
            }
            else break
        }
    }
    var res=0
    var resMul=1
    for(i in 0 until 4){
        if(wheel[i][0]=='1'){
            res+=resMul
        }
        resMul*=2
    }
    bw.write("$res\n")
    bw.close()
}