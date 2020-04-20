package `2019-kakao-intern`

import java.util.*

fun main() {

    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0

        val boardStack = List(board.size) { Stack<Int>() }
        val bucket = Stack<Int>()

        for (j in board.indices) {
            for (i in board.size - 1 downTo 0) {
                if (board[i][j] != 0) {
                    boardStack[j].push(board[i][j])
                }
            }
        }

        for (move in moves) {
            if (boardStack[move-1].isEmpty()) {
                continue
            }
            val pull = boardStack[move-1].pop()
            if (bucket.isEmpty() || bucket.peek() != pull) {
                bucket.push(pull)
                continue
            }
            answer += 2
            bucket.pop()
        }

        return answer
    }
}