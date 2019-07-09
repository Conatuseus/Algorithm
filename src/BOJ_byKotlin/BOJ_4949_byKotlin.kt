package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))


    while (true){
        val str=br.readLine()!!
        if (str==".") break

        var res=true
        val stack=Stack<Int>()
        for (ch in str){
            when(ch){
                '(' -> stack.push(1)
                '[' -> stack.push(2)
                ')' -> if(stack.isEmpty()||stack.pop()!=1){
                    res=false
                }
                ']' -> if(stack.isEmpty()||stack.pop()!=2){
                    res=false
                }
            }
        }
        bw.write(if(stack.isEmpty()&&res) "yes\n" else "no\n")
    }
    bw.close()
}