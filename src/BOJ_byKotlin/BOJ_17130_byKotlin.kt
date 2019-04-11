package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (r, c) = br.readLine()!!.split(' ').map { it.toInt() }
    val map = Array(r) { br.readLine()!! }
    val dp = Array(r) { IntArray(c){-1} }

    var startY=1
    for(i in 0 until r){
        for(j in 0 until c){
            if(map[i][j]=='R'){
                dp[i][j]=0
                startY=j
            }
        }
    }
    var res = -1

    val dx= arrayOf(-1,0,1)
    val dy= arrayOf(-1,-1,-1)
    fun isValid(x:Int,y:Int)=x in 0 until r && y in 0 until c

    for (j in startY+1 until c) {
        for(i in 0 until r) {
            if(map[i][j]!='#'){
                for(k in 0 until 3){
                    val bx=i+dx[k]
                    val by=j+dy[k]
                    if(isValid(bx,by)){
                        if(dp[bx][by]!=-1){
                            dp[i][j]= max(dp[i][j],dp[bx][by])
                        }
                    }
                }
                if(map[i][j]=='C'&&dp[i][j]!=-1){
                    dp[i][j]+=1
                }
                else if(map[i][j]=='O'){
                    res= max(res,dp[i][j])
                }
            }
        }
    }
    bw.write("$res\n")
    bw.close()
}