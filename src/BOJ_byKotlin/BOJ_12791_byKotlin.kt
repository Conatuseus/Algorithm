package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val hm=HashMap<Int,MutableList<String>>()

    hm[1967]= mutableListOf("DavidBowie")
    hm[1969]= mutableListOf("SpaceOddity")
    hm[1970]= mutableListOf("TheManWhoSoldTheWorld")
    hm[1971]= mutableListOf("HunkyDory")
    hm[1972]= mutableListOf("TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars")
    hm[1973]= mutableListOf("AladdinSane","PinUps")
    hm[1974]= mutableListOf("DiamondDogs")
    hm[1975]= mutableListOf("YoungAmericans")
    hm[1976]= mutableListOf("StationToStation")
    hm[1977]= mutableListOf("Low","Heroes")
    hm[1979]= mutableListOf("Lodger")
    hm[1980]= mutableListOf("ScaryMonstersAndSuperCreeps")
    hm[1983]= mutableListOf("LetsDance")
    hm[1984]= mutableListOf("Tonight")
    hm[1987]= mutableListOf("NeverLetMeDown")
    hm[1993]= mutableListOf("BlackTieWhiteNoise")
    hm[1995]= mutableListOf("1.Outside")
    hm[1997]= mutableListOf("Earthling")
    hm[1999]= mutableListOf("Hours")
    hm[2002]= mutableListOf("Heathen")
    hm[2003]= mutableListOf("Reality")
    hm[2013]= mutableListOf("TheNextDay")
    hm[2016]= mutableListOf("BlackStar")

    repeat(br.readLine()!!.toInt()){
        val (s,e)=br.readLine()!!.split(' ').map { it.toInt() }
        var count=0
        for(i in s..e){
            if(hm.containsKey(i)){
                count+=hm[i]!!.size
            }
        }
        println(count)
        for(i in s..e){
            if(hm.contains(i)){
                hm[i]!!.forEach { println("$i $it") }
            }
        }
    }


}