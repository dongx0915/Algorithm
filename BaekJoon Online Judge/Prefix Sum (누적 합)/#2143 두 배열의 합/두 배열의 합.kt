import java.util.*
import kotlin.collections.HashMap

val aList = arrayListOf<Long>().apply { add(0) }
val bList = arrayListOf<Long>().apply { add(0) }

fun solve(t:Int, an:Int, bn:Int):Long {
    var cnt:Long = 0
    val map = HashMap<Long, Long>()

    for (i in 0 .. an){
        for (j in i+1 .. an){
            val a = aList[j] - aList[i]
            map[a] = map[a]?.plus(1) ?: 1L
        }
    }

    for (i in 0 .. bn){
        for (j in i+1 .. bn){
            val b = t - (bList[j] - bList[i])
            cnt += map[b] ?: 0L
        }
    }

    return cnt
}


fun main(){
    val t = readln().toInt()

    val an = readln().toInt()
    StringTokenizer(readln()).apply {
        repeat(an){
            aList.add(aList[it] + nextToken().toInt())
        }
    }

    val bn = readln().toInt()
    StringTokenizer(readln()).apply {
        repeat(bn){
            bList.add(bList[it] + nextToken().toInt())
        }
    }

    println(solve(t,an,bn))
}