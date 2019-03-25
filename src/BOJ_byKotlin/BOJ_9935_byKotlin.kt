package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val str=br.readLine()!!
    val strLen=str.length
    val bomb=br.readLine()!!
    val bombLen=bomb.length
    val res=Stack<Char>()

    for(i in 0 until strLen){
        res.push(str[i])
        var chk=true
        if(str[i]==bomb[bombLen-1]&&res.size>=bombLen){
            var k=bombLen-2
            for(j in res.size-2 downTo res.size-bombLen) {
                if (res[j] != bomb[k]) {
                    chk = false
                    break
                }
                else
                    k--
            }
            if(chk)
                for(j in 0 until bombLen)   res.pop()

        }
        else
            continue
    }
    bw.write(if(res.size==0) "FRULA" else res.toList().joinToString("") +"\n")
    bw.close()
}