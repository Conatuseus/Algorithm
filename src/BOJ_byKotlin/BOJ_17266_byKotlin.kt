package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val len=br.readLine()!!.toInt()
    val numberOfLight=br.readLine()!!.toInt()
    val light=br.readLine()!!.split(' ').map { it.toInt() }
    var res= max(light.first(),len-light.last())
    for (i in 1 until numberOfLight){
        res= max(res,(light[i]-light[i-1]+1)/2)
    }
    bw.write("$res\n")
    bw.close()
}