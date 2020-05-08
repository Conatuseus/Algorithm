package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val n=br.readLine()!!.toInt()

    val a=IntArray(n)
    val b=IntArray(n)
    val c=IntArray(n)
    val d=IntArray(n)

    val arr=Array(2){IntArray(n*n)}

    repeat(n) {
        val (aa,bb,cc,dd)=br.readLine()!!.split(" ").map { it.toInt() }
        a[it]=aa
        b[it]=bb
        c[it]=cc
        d[it]=dd
    }

    var idx=0
    for (i in 0 until n) {
        for (j in 0 until n) {
            arr[0][idx]=a[i]+b[j]
            arr[1][idx]=c[i]+d[j]
            idx++
        }
    }

    arr.forEach { Arrays.sort(it) }

    fun binarySearch(arr: IntArray, start: Int, end: Int, find: Int): Int {
        var s = start
        var e = end

        while (s <= e) {
            val mid = (s + e) / 2

            if (arr[mid] == find) {
                return mid
            }
            if (arr[mid] < find) {
                s = mid + 1
            } else {
                e = mid - 1
            }
        }
        return -1
    }

    fun findAll(arr:Array<IntArray>, firStart:Int,secStart:Int):Long{
        var firCount=1L
        var secCount=1L

        for (i in firStart-1 downTo 0) {
            if (i<0) break
            if (arr[0][i]==arr[0][i+1]) {
                firCount++
            }
            else break
        }
        for (i in firStart+1 until n*n) {
            if (arr[0][i]==arr[0][i-1]) {
                firCount++
            }
            else break
        }

        for (i in secStart-1 downTo 0) {
            if (i<0) break
            if (arr[1][i]==arr[1][i+1]) {
                secCount++
            }
            else break
        }
        for (i in secStart+1 until n*n) {
            if (arr[1][i]==arr[1][i-1]) {
                secCount++
            }
            else break
        }
        return firCount*secCount
    }
    var res=0L

    for (i in 0 until n*n) {
        if (i>0&&arr[0][i-1]==arr[0][i]) continue
        val idx=binarySearch(arr[1],0,n*n-1,arr[0][i]*(-1))
        if (idx==-1) continue
        res+=findAll(arr,i,idx)
    }
    println(res)
}