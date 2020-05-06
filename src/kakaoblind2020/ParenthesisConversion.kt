package kakao_blind_2020

import java.lang.StringBuilder
import java.util.*

fun main() {

    fun isValid(p: String) :Boolean{
        val stack=Stack<Char>()
        for (ch in p) {
            if (ch=='(') {
                stack.push(ch)
                continue
            }
            if (stack.isEmpty()) {
                return false
            }
            stack.pop()
        }
        return stack.size==0
    }

    fun divide(p:String) :Int {
        var count=0
        for (i in p.indices) {
            if (p[i]=='(') {
                count++
            }
            else {
                count--
            }
            if (count==0) {
                return i
            }
        }
        return -1
    }

    fun reverse(str:String) :String {
        val tmp=str.substring(1,str.length-1)
        val sb=StringBuilder()
        for (i in tmp.indices) {
            if (tmp[i]=='(') {
                sb.append(')')
            }
            else {
                sb.append('(')
            }
        }
        return sb.toString()
    }

    fun process(str:String) :String {
        if (str.isBlank()) return ""
        if (isValid(str)) return str
        val res=""
        val dividedIndex=divide(str)
        if (dividedIndex==-1) {
            return res+"()"+reverse(str)
        }
        val u=str.substring(0,dividedIndex+1)
        val v=str.substring(dividedIndex+1)

        return if (isValid(u)) {
            u+process(v)
        } else {
            var tmp="("
            tmp+=process(v)
            tmp+=")"
            tmp+=reverse(u)
            res+tmp
        }
    }

    fun solution(p: String): String {
        return process(p)
    }

//    println(solution(")("))
    println(solution("()))((()"))
}