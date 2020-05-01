package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine()!!.split(" ").map { it.toInt() }
    val arr = IntArray(n) { br.readLine()!!.toInt() }

    data class Node(val start: Int, val end: Int, var left: Node? = null, var right: Node? = null) {
        var max: Int = Int.MIN_VALUE
        var min: Int = Int.MAX_VALUE
    }

    fun init(nowNode: Node, start: Int, end: Int): Node {
        if (start == end) {
            nowNode.max = arr[start-1]
            nowNode.min = arr[start-1]
            return nowNode
        }
        nowNode.left = init(Node(start, (start + end) / 2), start, (start + end) / 2)
        nowNode.right = init(Node((start + end) / 2 + 1, end), (start + end) / 2 + 1, end)
        nowNode.max = max(nowNode.left!!.max, nowNode.right!!.max)
        nowNode.min = min(nowNode.left!!.min, nowNode.right!!.min)
        return nowNode
    }

    fun findRes(nowNode:Node,start:Int,end:Int):Pair<Int,Int>{
        if (nowNode.start>end||nowNode.end<start) {
            return Pair(Int.MIN_VALUE, Int.MAX_VALUE)
        }
        if (start<=nowNode.start&&nowNode.end<=end) {
            return Pair(nowNode.max, nowNode.min)
        }
        val left=findRes(nowNode.left!!,start,end)
        if (nowNode.right!=null) {
            val right=findRes(nowNode.right!!,start,end)
            return Pair(max(left.first,right.first), min(left.second,right.second))
        }
        return Pair(left.first,left.second)
    }

    val root=Node(1,n)
    init(root, 1,n)

    repeat(m) {
        val (start, end) = br.readLine()!!.split(" ").map { it.toInt() }
        val res=findRes(root, start,end)
        println("${res.second} ${res.first}")
    }
}