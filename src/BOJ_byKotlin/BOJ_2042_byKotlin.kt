package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (n,m,k)=br.readLine()!!.split(" ").map { it.toInt() }
    val arr = LongArray(n){br.readLine()!!.toLong()}

    data class Node(val start:Int, val end:Int, var value:Long, var left:Node?=null, var right:Node?=null) {
        fun hasLeft()=left!=null
        fun hasRight()=right!=null
    }

    fun initTree(nowNode:Node) :Node {
        val start = nowNode.start
        val end = nowNode.end
        if (start==end) {
            nowNode.value = arr[start-1]
            return nowNode
        }
        nowNode.left = initTree(Node(start,(start+end)/2,0))
        nowNode.right = initTree(Node((start+end)/2 +1, end,0))
        nowNode.value = if (nowNode.hasRight()) nowNode.left!!.value + nowNode.right!!.value else nowNode.left!!.value
        return nowNode
    }

    val root = Node(1, n,0)
    initTree(root)

    fun findSum(nowNode:Node,start:Int, end:Int):Long{
        if (nowNode.start > end || nowNode.end<start) return 0L
        if (nowNode.start>=start && nowNode.end<=end) {
            return nowNode.value
        }
        return findSum(nowNode.left!!, start, end) + findSum(nowNode.right!!, start,end)
    }

    fun changeValue(nowNode:Node, index:Int, newValue:Long) {
        if (index !in nowNode.start..nowNode.end) {
            return
        }
        if (nowNode.start==nowNode.end&&nowNode.start == index) {
            nowNode.value = newValue
        }
        if (nowNode.hasLeft()) {
            val prevLeftValue = nowNode.left!!.value
            changeValue(nowNode.left!!, index,newValue)
            nowNode.value = nowNode.value - prevLeftValue + nowNode.left!!.value
        }
        if (nowNode.hasRight()) {
            val prevRightValue = nowNode.right!!.value
            changeValue(nowNode.right!!, index,newValue)
            nowNode.value = nowNode.value - prevRightValue + nowNode.right!!.value
        }
    }

    repeat(m+k) {
        val (a,b,c)=br.readLine()!!.split(" ").map { it.toLong() }
        if (a==1L) {
            changeValue(root,b.toInt(),c)
        }
        if (a==2L) {
            println(findSum(root,b.toInt(),c.toInt()))
        }
    }

}