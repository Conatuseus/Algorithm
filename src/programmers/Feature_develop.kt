package programmers

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var days = 101
        var count = 0
        for (i in 0 until progresses.size) {
            val nowCountDays =
                if ((100 - progresses[i]) % speeds[i] == 0) (100 - progresses[i]) / speeds[i] else ((100 - progresses[i]) / speeds[i] )+ 1
            if (days >= nowCountDays) {
                if(days==101)   days=nowCountDays
                count++
            } else {
                days=nowCountDays
                answer.add(count)
                count = 1
            }
            if(i==progresses.size-1){
                answer.add(count)
            }
        }

        return answer.toIntArray()
    }
}
