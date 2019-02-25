package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val fir=br.readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    val sec=br.readLine()!!.split(' ').map { it.toInt() }.toIntArray()


    var firWin=0
    var secWin=0
    (0..9).forEach { if(fir[it]>sec[it]) firWin++ else if(fir[it]<sec[it]) secWin++ }
    bw.write(if(firWin>secWin) "A\n" else if(firWin<secWin) "B\n" else "D\n")
    bw.close()
}