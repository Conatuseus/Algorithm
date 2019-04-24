package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br= BufferedReader(InputStreamReader(System.`in`))
    val (n,k)=br.readLine()!!.split(" ").map { it.toInt() }
    val st=StringTokenizer(br.readLine())
    val arr=IntArray(n)
    var i=0
    while (st.hasMoreTokens()){
        arr[i++]=st.nextToken().toInt()
    }
    val tmp=IntArray(n)
    fun merge(left:Int,mid:Int,right:Int){
        var i=left
        var j=mid+1
        var k=left
        while(i<=mid&&j<=right){
            if(arr[i]<=arr[j]){
                tmp[k++]=arr[i++]
            }
            else{
                tmp[k++]=arr[j++]
            }
        }
        while(i<=mid)   tmp[k++]=arr[i++]
        while(j<=right) tmp[k++]=arr[j++]
        for(p in left..right)   arr[p]=tmp[p]
    }
    fun mergeSort(left:Int,right:Int){
        if(left<right){
            val mid=(left+right)/2
            mergeSort(left,mid)
            mergeSort(mid+1,right)
            merge(left,mid,right)
        }
    }
    mergeSort(0,n-1)
    println("${arr[k-1]}")
}