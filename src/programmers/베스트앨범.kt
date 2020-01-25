package programmers

import java.util.*
import kotlin.collections.HashMap

fun main() {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = mutableListOf<Int>()

        data class Info(val gen: String, var allPlayNum: Int) : Comparable<Info> {
            override fun compareTo(other: Info): Int {
                return other.allPlayNum - this.allPlayNum
            }
        }

        data class Pair(val idx: Int, var playNum: Int) : Comparable<Pair> {
            override fun compareTo(o: Pair): Int {
                if (this.playNum != o.playNum) return o.playNum - this.playNum
                return this.idx - o.idx
            }
        }

        val pq = PriorityQueue<Info>()
        val hs = HashMap<String, PriorityQueue<Pair>>()
        (genres.indices).forEach {
            if (hs[genres[it]] == null) hs[genres[it]] = PriorityQueue()
            hs[genres[it]]!!.add(Pair(it, plays[it]))
        }

        hs.forEach { (t, u) -> pq.add(Info(t, u.sumBy { it.playNum })) }
        while (!pq.isEmpty()) {
            val p = pq.poll()
            var count = 0
            while (!hs[p.gen]!!.isEmpty() && count++ < 2) {
                val pair = hs[p.gen]!!.poll()
                answer.add(pair.idx)
            }
        }
        return answer.toIntArray()
    }
}