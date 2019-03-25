package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val k=br.readLine()!!.toInt()
    val c=br.readLine()!!.toInt()

    repeat(c){
        val (m,n)=br.readLine()!!.split(' ').map { it.toInt() }
        val max= max(m,n)
        bw.write(
            if(m>n){
                if(m-n<=k-max+2)    "1\n"
                else    "0\n"
            }
            else if(m<n){
                if(n-m<=k-max+1)  "1\n"
                else "0\n"
            }
            else{
                "1\n"
            }
        )
    }

    bw.close()
}