package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (a,b,c)=br.readLine()!!.split(" ").map { it.toInt() }

    if (a*b==c) {
        println("$a*$b=$c")
    }
    else if (a+b==c) {
        println("$a+$b=$c")
    }
    else if (a-b==c) {
        println("$a-$b=$c")
    }
    else if (b!=0&&a/b==c&&a%b==0) {
        println("$a/$b=$c")
    }
    else if (a==b*c) {
        println("$a=$b*$c")
    }
    else if (a==b+c) {
        println("$a=$b+$c")
    }
    else if (a==b-c) {
        println("$a=$b-$c")
    }
    else if (c!=0&&a==b/c&&b%c==0) {
        println("$a=$b/$c")
    }
}