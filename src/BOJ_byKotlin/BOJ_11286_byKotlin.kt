package BOJ_byKotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val positivePq=PriorityQueue<Long>()
    val negativePq=PriorityQueue<Long>(reverseOrder())

    fun toPositive(negativeNum:Long)=negativeNum*(-1)
    repeat(br.readLine()!!.toInt()){
        val num=br.readLine()!!.toLong()
        when{
            num<0L -> negativePq.add(num)
            num>0L -> positivePq.add(num)
            num==0L -> if(positivePq.isEmpty()&&negativePq.isEmpty()){
                bw.write("0\n")
            }
            else if(positivePq.isEmpty()){
                bw.write("${negativePq.poll()}\n")
            }
            else if(negativePq.isEmpty()){
                bw.write("${positivePq.poll()}\n")
            }
            else if(positivePq.peek()==toPositive(negativePq.peek())){
                bw.write("${negativePq.poll()}\n")
            }
            else if(positivePq.peek()>toPositive(negativePq.peek())){
                bw.write("${negativePq.poll()}\n")
            }
            else{
                bw.write("${positivePq.poll()}\n")
            }
        }
    }

    bw.close()
}