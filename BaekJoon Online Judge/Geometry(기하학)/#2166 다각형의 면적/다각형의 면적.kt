import kotlin.math.abs

fun solve(list:ArrayList<Pair<Long,Long>>, n:Int):String{
    list.add(list[0])

    var xSum:Long = 0
    var ySum:Long = 0
    for (i in 0 until n){
        xSum += list[i].first * list[i+1].second
        ySum += list[i].second * list[i+1].first
    }

    val result = abs((xSum - ySum))
    return "${result shr 1}.${(result and 1) * 5}"
}

fun main(){
    val n = readln().toInt()
    val list = arrayListOf<Pair<Long,Long>>()

    repeat(n){
        list.add(
            readln().split(" ").map { it.toLong() }.let { Pair(it[0], it[1]) })
    }

    println(solve(list,n))
}