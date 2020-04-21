package kakaoitern2019

import kotlin.math.min

fun main() {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = Int.MAX_VALUE

        val bridgeLen = stones.size
        var now = -1

        while (now < bridgeLen) {
            val nowMaxPosition = if (now + k >= bridgeLen) bridgeLen - 1 else now + k
            var nextPosition = now
            var nextMaxValue = 0

            for (next in now + 1..nowMaxPosition) {
                if (stones[next] >= nextMaxValue) {
                    nextPosition = next
                    nextMaxValue = stones[next]
                }
            }
            now = nextPosition
            answer = min(answer, nextMaxValue)

            if (now + k >= bridgeLen) break
        }

        return answer
    }
}