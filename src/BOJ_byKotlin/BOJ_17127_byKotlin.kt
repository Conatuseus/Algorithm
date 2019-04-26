package BOJ_byKotlin

import java.io.*
import kotlin.math.max

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val N=br.readLine()!!.toInt()
    val arr=br.readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val add=BooleanArray(N-1)
    var res=0
    fun cal():Int{
        var sum= arr[0]
        var mul=1
        for(i in 1 until N){
            mul*=arr[i]
            if(add[i-1]){
                sum+=mul
                mul=1
            }
        }
        return sum
    }
    fun defAdd(i:Int,count:Int){
        if(count>3) return
        if(count==3)    {
            res= max(res,cal())
        }
        else {
            for (next in i + 1 until N-1) {
                add[next] = true
                defAdd(next, count + 1)
                add[next] = false
                defAdd(next, count)
            }
        }
    }
    defAdd(0,0)
    add[0]=true
    defAdd(0,1)
    add[1]=false
    bw.write("$res\n")
    bw.close()
}