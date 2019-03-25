package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))

    while(true){
        val str=br.readLine()!!
        if(str=="-1")   break
        val arr=str.split(' ').map { it.toInt() }.sorted()
        val chk=BooleanArray(201)
        var res=0
        for(i in arr.size-1 downTo 1){
            chk[arr[i]]=true
            if(chk[arr[i]*2])   res++
        }
        println(res)
    }
}