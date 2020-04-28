package kakaoitern2019

import java.util.*
import kotlin.collections.HashSet

fun main() {

    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        val res =HashSet<String>()

        fun isEqual(str1:String, str2:String):Boolean{
            for (i in str1.indices) {
                if (str2[i]=='*') continue
                if (str1[i]!=str2[i]) return false
            }
            return true
        }

        fun go(isVisit:BooleanArray,bannedIndex:Int,str:String) {
            if (bannedIndex>=banned_id.size) {
                res.add(str.toCharArray().sorted().toString())
                return
            }

            for (i in user_id.indices) {
                if (isVisit[i]) continue
                if (user_id[i].length!=banned_id[bannedIndex].length) {
                    continue
                }
                if (isEqual(user_id[i], banned_id[bannedIndex])) {
                    isVisit[i]=true
                    go(isVisit, bannedIndex+1,str+i)
                    isVisit[i]=false
                }
            }
        }
        go(BooleanArray(user_id.size){false}, 0, "")
        return res.size
    }

    println(solution(arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"), arrayOf("fr*d*", "abc1**")))
}