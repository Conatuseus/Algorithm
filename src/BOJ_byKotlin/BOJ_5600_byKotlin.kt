package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (a,b,c)=br.readLine()!!.split(' ').map { it.toInt() }
    val n=br.readLine()!!.toInt()
    val chk=Array(n){br.readLine()!!.split(' ').map { it.toInt() }}
    val res=IntArray(a+b+c+1){2}
    for(i in 0 until n){
        if(chk[i][3]==1){
            for(j in 0 until 3){
                res[chk[i][j]]=1
            }
        }
    }
    repeat(2) {
        for (i in 0 until n) {
            if (chk[i][3] == 0) {
                if (res[chk[i][0]] == 2) {
                    if (res[chk[i][1]] == 1 && res[chk[i][2]] == 1) res[chk[i][0]] = 0
                }
                if (res[chk[i][1]] == 2) {
                    if (res[chk[i][0]] == 1 && res[chk[i][2]] == 1) res[chk[i][1]] = 0
                }
                if (res[chk[i][2]] == 2) {
                    if (res[chk[i][0]] == 1 && res[chk[i][1]] == 1) res[chk[i][2]] = 0
                }
            }
        }
    }
    for(i in 1..a+b+c){
        bw.write("${res[i]}\n")
    }
    bw.close()
}