package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val sb=StringBuilder()
    var count=0
    while (true){
        val str=br.readLine()?:break
        val st=StringTokenizer(str)

        while (st.hasMoreTokens()) {
            val now = st.nextToken()
            when (now) {
                "<br>"  -> {
                    sb.append("\n")
                    count=0
                }
                "<hr>" -> {
                    if(count!=0)    sb.append("\n")
                    repeat(80){
                        sb.append("-")
                    }
                    sb.append("\n")
                    count=0
                }
                else -> {
                    if (count + now.length > 80) {
                        sb.append("\n$now")
                        count = now.length
                    } else {
                        sb.append(now)
                        count += now.length
                    }
                    if(count+1>80){
                        count=0
                        sb.append("\n")
                    }
                    else   {
                        sb.append(" ")
                        count++
                    }
                }
            }
        }
    }
    println(sb.toString())
}