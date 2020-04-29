package kakaoitern2019

fun main() {
    fun solution(k: Long, room_number: LongArray): LongArray {
        val answer= LongArray(room_number.size)
        val tmp = HashMap<Long,Long>()

        fun findRoom(position:Long) :Long{
            if (!tmp.containsKey(position)) {
                tmp[position] = position+1
                return position
            }
            val emptyRoom = findRoom(tmp[position]!!)
            tmp[position] = emptyRoom+1
            return emptyRoom
        }

        for (i in room_number.indices) {
            answer[i] = findRoom(room_number[i])
        }
        answer.forEach { print("$it ") }

        return answer
    }

    solution(10L, longArrayOf(1,3,4,1,3,1))
}