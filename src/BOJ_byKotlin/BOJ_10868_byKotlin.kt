package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (n,m)=br.readLine()!!.split(" ").map { it.toInt() }
    val arr=IntArray(n){br.readLine()!!.toInt()}

    data class Node(val start:Int, val end:Int, var min:Int=Int.MAX_VALUE) {
        var left:Node?=null
        var right:Node?=null
    }

    fun init(nowNode:Node,start:Int,end:Int):Node{
        if (start==end) {
            nowNode.min=arr[start-1]
            return nowNode
        }
        nowNode.left = init(Node(start,(start+end)/2),start,(start+end)/2)
        nowNode.right=init(Node((start+end)/2+1,end),(start+end)/2+1,end)
        nowNode.min = min(nowNode.left!!.min, nowNode.right!!.min)
        return nowNode
    }

    val root=Node(1,n)
    init(root,1,n)

    fun findMin(nowNode:Node,start:Int,end:Int) :Int {
        if (start>nowNode.end || end<nowNode.start) {
            return Int.MAX_VALUE
        }
        if (start<=nowNode.start&&nowNode.end<=end) {
            return nowNode.min
        }
        if (nowNode.right!=null) {
            return min(findMin(nowNode.left!!, start,end), findMin(nowNode.right!!, start,end))
        }
        return findMin(nowNode.left!!,start,end)
    }

    repeat(m) {
        val (s,e)=br.readLine()!!.split(" ").map { it.toInt() }
        println(findMin(root, s,e))
    }
}