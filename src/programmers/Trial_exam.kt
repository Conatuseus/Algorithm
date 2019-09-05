package programmers

class Trial_exam {
    fun solution(answers: IntArray): IntArray {
        var answer = mutableListOf<Int>()

        val res1="12345".repeat((answers.size+4)/5)
        val res2="21232425".repeat((answers.size+7)/8)
        val res3="3311224455".repeat((answers.size+9)/10)

        val res=IntArray(3)

        for (i in 0 until answers.size){
            if((res1[i].toInt()-48)==answers[i]){
                res[0]++
            }
            if((res2[i].toInt()-48)==answers[i]){
                res[1]++
            }
            if((res3[i].toInt()-48)==answers[i]){
                res[2]++
            }
        }
        val max=res.max()
        res.forEachIndexed { index, num -> if(num==max) answer.add(index+1)  }
        return answer.toIntArray()
    }
}