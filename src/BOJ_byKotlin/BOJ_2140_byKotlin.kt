package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val n=br.readLine()!!.toInt()
    val matrix=Array(n){br.readLine()!!.toCharArray()}

    val dx= arrayOf(-1,-1,-1,0,0,1,1,1)
    val dy= arrayOf(-1,0,1,-1,1,-1,0,1)

    if(n<=2){
        bw.write("0\n")
        bw.close()
        return
    }
    var res=(n-2)*(n-2)
    fun chk(i:Int,j:Int):Boolean{
        for(k in 0 until 8){
            val bx=i+dx[k]
            val by=j+dy[k]
            if(bx in 0 until n && by in 0 until n) {
                if (matrix[bx][by] == '0') {
                    return false
                }
            }
        }
        return true
    }

    for(i in 1 until n-1){
        for(j in 1 until n-1){
            if(i==1||i==n-2||j==1||j==n-2){
                if(chk(i,j)){
                    for(k in 0 until 8){
                        val bx=i+dx[k]
                        val by=j+dy[k]
                        if(bx in 0 until n && by in 0 until n) {
                            if(matrix[bx][by] in '1'..'3')
                                matrix[bx][by]--
                        }
                    }
                }
                else    res--
            }
        }
    }

    bw.write("$res\n")
    bw.close()
}