package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine()!!.toInt()
    val building = br.readLine()!!.split(' ').map { it.toInt() }.toIntArray()

    val res=IntArray(N)
    for (i in 0 until N) {
        var maxIncline = -9e9

        for(j in i+1 until N){
            val thisIncline=(building[j]-building[i]).toDouble()/(j-i)
            if(thisIncline>maxIncline){
                res[i]++
                res[j]++
                maxIncline=thisIncline
            }
        }
    }
    bw.write("${res.max()}\n")
    bw.close()
}