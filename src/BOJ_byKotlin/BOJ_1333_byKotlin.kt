package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))
    val (n,l,d)=br.readLine()!!.split(' ').map { it.toInt() }
    when {
        5*(n-1)+l*n<=d -> bw.write("$d\n")
        else -> {
            var chk=false
            var res=0
            var now=0
            var nowD=d
            while (now<5*(n-1)+l*n){
                now+=l+5
                while (nowD<now) {
                    if (nowD >= now - 5) {
                        res = if (nowD == now - 5) now - 5
                        else nowD
                        chk = true
                        break
                    }
                    nowD += d
                    if(nowD>=now)   break
                }
                if(chk) break
            }
            bw.write(if(chk) "$res\n" else "$nowD\n")
        }
    }
    bw.close()
}