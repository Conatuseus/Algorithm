package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val str=br.readLine()!!
    val st=Stack<Char>()
    str.forEach { st.push(it) }
    var nowNum=0
    var res=0

    while (!st.empty()){
        val ch=st.pop()
        if(ch==')'){
            if(st.peek()=='('){
                res+=nowNum
                st.pop()
            }
            else nowNum+=1
        }
        else{
            res+=1
            nowNum-=1
        }
    }
    bw.write("$res\n")
    bw.close()
}