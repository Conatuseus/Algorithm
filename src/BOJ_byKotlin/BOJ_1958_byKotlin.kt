package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val str = Array(3) {br.readLine()}

    val arr = Array(str[0].length+1){Array(str[1].length+1){IntArray(str[2].length+1)} }
    var res=0

    for (i in 1..str[0].length) {
        for (j in 1..str[1].length) {
            for (k in 1..str[2].length) {
                if (str[0][i-1]==str[1][j-1]&&str[1][j-1]==str[2][k-1]) {
                    arr[i][j][k] = arr[i-1][j-1][k-1] + 1
                }
                else {
                    arr[i][j][k]= max(arr[i-1][j][k], max(arr[i][j-1][k],arr[i][j][k-1]))
                }
                res= max(res, arr[i][j][k])
            }
        }
    }
    println(res)
}