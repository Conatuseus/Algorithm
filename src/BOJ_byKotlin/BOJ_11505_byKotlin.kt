package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, k) = br.readLine()!!.split(" ").map { it.toInt() }
    val arr = LongArray(n) { br.readLine()!!.toLong() }
    val mod = 1000000007L

    data class Node(val start: Int, val end: Int) {
        var left: Node? = null
        var right: Node? = null
        var mul = 1L
    }

    fun init(nowNode: Node, start: Int, end: Int) {
        if (nowNode.start > end || nowNode.end < start) {
            return
        }
        if (start == end) {
            nowNode.mul = arr[start - 1]
            return
        }
        nowNode.left = Node(start, (start + end) / 2)
        init(nowNode.left!!, start, (start + end) / 2)
        nowNode.right = Node((start + end) / 2 + 1, end)
        init(nowNode.right!!, (start + end) / 2 + 1, end)
        nowNode.mul = (nowNode.left!!.mul * nowNode.right!!.mul) % mod
    }

    fun findMul(nowNode: Node, start: Int, end: Int): Long {
        if (nowNode.start > end || nowNode.end < start) {
            return 1L
        }
        if (nowNode.start == nowNode.end) {
            return nowNode.mul
        }
        if (start <= nowNode.start && nowNode.end <= end) {
            return nowNode.mul
        }
        if (nowNode.right != null) {
            return (findMul(nowNode.left!!, start, end) * findMul(nowNode.right!!, start, end)) % mod
        }
        return findMul(nowNode.left!!, start, end)
    }

    fun changeValue(nowNode: Node, index: Int, value: Long) {
        if (index !in nowNode.start..nowNode.end) return
        val prev = arr[index - 1]

        if (nowNode.start == nowNode.end && nowNode.start == index) {
            nowNode.mul = value
            arr[index - 1] = value
            return
        }
        if (nowNode.right != null) {
            changeValue(nowNode.left!!, index, value)
            changeValue(nowNode.right!!, index, value)
            if (value == 0L) {
                nowNode.mul = 0L
            } else  {
                nowNode.mul = (nowNode.left!!.mul * nowNode.right!!.mul) % mod
            }
        } else {
            changeValue(nowNode.left!!, index, value)
            if (value == 0L) {
                nowNode.mul = 0L
            } else{
                nowNode.mul =(nowNode.left!!.mul*value)%mod
            }
        }
    }

    val root = Node(1, n)
    init(root, 1, n)
    repeat(m + k) {
        val (a, b, c) = br.readLine()!!.split(" ").map { it.toLong() }
        if (a == 1L) {
            changeValue(root, b.toInt(), c)
        } else {
            println(findMul(root, b.toInt(), c.toInt()))
        }
    }
}