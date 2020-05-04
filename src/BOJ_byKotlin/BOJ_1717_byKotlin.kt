package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (n,m)=br.readLine()!!.split(" ").map { it.toInt() }

    val parent=IntArray(n+1){it}

    fun find(x:Int) :Int {
        if (parent[x]==x) {
            return x
        }
        val root=find(parent[x])
        parent[x]=root
        return root
    }

    fun union(x:Int,y:Int) {
        val rootX=find(x)
        val rootY=find(y)

        if (rootX!=rootY) {
            parent[rootY]=rootX
        }
    }

    repeat(m) {
        val (case, a,b)=br.readLine()!!.split(" ").map { it.toInt() }
        if (case==0) {
            union(a,b)
        }
        else {
            println(if (find(a)==find(b)) "YES" else "NO")
        }
    }
}