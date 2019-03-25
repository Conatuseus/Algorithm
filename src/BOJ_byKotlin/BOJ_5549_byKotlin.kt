package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (r,c)=br.readLine()!!.split(' ').map { it.toInt() }
    val k=br.readLine()!!.toInt()
    val map=Array(r){br.readLine()!!.toCharArray()}

    data class Triple(var f:Int,var s:Int,var t:Int){
        fun oper(o:Triple,chk:Boolean){
            if(chk){
                this.f+=o.f
                this.s+=o.s
                this.t+=o.t
            }
            else{
                this.f-=o.f
                this.s-=o.s
                this.t-=o.t
            }
        }
    }
    val save=Array(r){Array(c){Triple(0,0,0)}}
    for(i in 0 until r){
        for(j in 0 until c){
            if(i-1>=0)  save[i][j].oper(save[i-1][j],true)
            if(j-1>=0)  save[i][j].oper(save[i][j-1],true)
            if(i-1>=0&&j-1>=0)  save[i][j].oper(save[i-1][j-1],false)
            when(map[i][j]){
                'J' -> save[i][j].f++
                'O' -> save[i][j].s++
                'I' -> save[i][j].t++
            }
        }
    }
    repeat(k){
        val (startX,startY,endX,endY)=br.readLine()!!.split(' ').map { it.toInt()-1 }
        val res=Triple(save[endX][endY].f,save[endX][endY].s,save[endX][endY].t)
        if(startX-1>=0)  res.oper(save[startX-1][endY],false)
        if(startY-1>=0)  res.oper(save[endX][startY-1],false)
        if(startX-1>=0&&startY-1>=0)  res.oper(save[startX-1][startY-1],true)
        bw.write("${res.f} ${res.s} ${res.t}\n")
    }
    bw.close()
}