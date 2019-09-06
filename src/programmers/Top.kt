package programmers

class Top {
    fun solution(heights: IntArray): IntArray {
        var answer = IntArray(heights.size)

        for (i in 1 until heights.size){
            for (j in i-1 downTo 0){
                if(heights[j]>heights[i]){
                    answer[i]=j
                    break
                }
            }
        }
        return answer
    }
}