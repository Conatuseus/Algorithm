package BOJ_byKotlin

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val n= readLine()!!.toInt()
    val bw=BufferedWriter(OutputStreamWriter(System.out))
    fun go(x:Int){
        when {
            x>2 -> bw.write("$x bottles of beer on the wall, $x bottles of beer.\n" +
                    "Take one down and pass it around, ${x-1} bottles of beer on the wall.\n\n")
            x==2 -> bw.write("$x bottles of beer on the wall, $x bottles of beer.\n" +
                    "Take one down and pass it around, ${x-1} bottle of beer on the wall.\n\n")
            x==1 -> bw.write("$x bottle of beer on the wall, $x bottle of beer.\n" +
                    "Take one down and pass it around, no more bottles of beer on the wall.\n\n")
            else -> bw.write("No more bottles of beer on the wall, no more bottles of beer. \n" +
                    "Go to the store and buy some more, $n ${if(n==1) "bottle" else "bottles"} of beer on the wall.\n")
        }
        if(x>0) go(x-1)
    }
    go(n)
    bw.close()
}