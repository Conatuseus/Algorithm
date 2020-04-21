package kakaoitern2019

fun main() {
    fun deleteBracket(str:String): String {
        return str.substring(1,str.length-1)
    }

    fun solution(s: String): IntArray {
        var answer = mutableListOf<Int>()

        val visit = BooleanArray(100001){false}

        val deleted = deleteBracket(deleteBracket(s)).split("},{")
        val sortedBy = deleted.sortedBy { it.length }

        for (str in sortedBy) {
            val nums = str.split(",").map { it.toInt() }
            for (num in nums) {
                if (!visit[num]) {
                    answer.add(num)
                    visit[num]=true
                }
            }
        }
        return answer.toIntArray()
    }
}