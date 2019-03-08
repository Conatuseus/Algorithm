package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val (p,w)=br.readLine()!!.split(' ').map { it.toInt() }
    // p = 버튼을 한번 누르는데 걸리는 시간
    // w = 같은 숫자인 문자를 연속으로 찍기위한 대기 시간

    val input=br.readLine()!!
    var res=0
    val arr= arrayOf("ADGJMPTW ","BEHKNQUX","CFILORVY","SZ")
    val checkArray=arrayOf(arrayOf('A','B','C'), arrayOf('D','E','F'), arrayOf('G','H','I'), arrayOf('J','K','L'),
        arrayOf('M','N','O'), arrayOf('P','Q','R','S'), arrayOf('T','U','V'), arrayOf('W','X','Y','Z'))
    for(i in 0..3){
        if(arr[i].contains(input[0])){
            res+=(i+1)*p
        }
    }
    for(i in 1 until input.length){
        for(j in 0 until 8){
            if(input[i] in checkArray[j]&& input[i-1] in checkArray[j]){
                res+=w
                break
            }
        }
        for(j in 0..3){
            if(arr[j].contains(input[i])){
                res+=(j+1)*p
            }
        }
    }
    bw.write("$res\n")
    bw.close()
}