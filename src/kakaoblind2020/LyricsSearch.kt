package kakaoblind2020

fun main() {

    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        var answer = IntArray(queries.size)

        data class Node(val ch:Char) {
            val nodes=HashMap<Char, Node>()
            val map=HashMap<Int,Int>()
        }

        val frontRoot=Node(' ')
        val reverseRoot=Node(' ')

        fun add(nowNode:Node,index:Int,str:String) {
            if (index==str.length) {
                return
            }
            if (nowNode.map.containsKey(str.length)) {
                nowNode.map[str.length]=nowNode.map[str.length]!!.plus(1)
            }
            else {
                nowNode.map[str.length]=1
            }
            val ch=str[index]
            if (nowNode.nodes.containsKey(ch)) {
                add(nowNode.nodes[ch]!!,index+1,str)
            }
            else {
                nowNode.nodes[ch]=Node(ch)
                add(nowNode.nodes[ch]!!,index+1,str)
            }
        }

        fun sum(nowNode:Node,index:Int,query:String) :Int{
            if (index==query.length) {
                return nowNode.map.getOrDefault(query.length, 0)
            }
            if (query[index]=='?') {
                 return nowNode.map.getOrDefault(query.length, 0)
            }
            val ch=query[index]
            if (nowNode.nodes.containsKey(ch)) {
                return sum(nowNode.nodes[ch]!!, index+1, query)
            }
            return 0
        }

        for (word in words) {
            add(frontRoot,0,word)
            add(reverseRoot,0,word.reversed())
        }

        for (i in queries.indices) {
            if (queries[i][0]=='?') {
                answer[i] = sum(reverseRoot, 0, queries[i].reversed())
            }
            else {
                answer[i] = sum(frontRoot, 0, queries[i])
            }
        }

        return answer
    }

    val res=solution(arrayOf("frodo", "front", "frost", "frozen", "frame", "kakao"), arrayOf("fro??", "????o", "fr???", "fro???", "pro?"))
    res.forEach { println(it) }
}