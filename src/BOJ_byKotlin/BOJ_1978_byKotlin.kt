package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val n=br.readLine()!!.toInt()

    val isPrime=BooleanArray(1001){true}
    isPrime[1]=false
    for (i in 2..1000){
        if(isPrime[i]){
            for (j in 2..500){
                if(i*j>1000){
                    break
                }
                isPrime[i*j]=false
            }
        }
    }
    bw.write("${br.readLine()!!.split(' ').map { it.toInt() }.filter { isPrime[it] }.count()}\n")
    bw.close()
}