package BOJ1701

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun makeTable(p:String, table:Array<Int>): Int {
    var j = 0
    for(i in 1 until p.length){
        // 불일치가 발생하면 가장 최근에 일치했던 곳으로 돌아가기
        while(j > 0 && p[i] != p[j]) j = table[j-1]

        if(p[i] == p[j]) table[i] = ++j
    }
    return table.maxOrNull()?:0
}

fun solve(str:String): Int{
    val table = Array<Int>(5002){0}
    var max = 0
    for (i in str.indices){
        max = max(max, makeTable(str.substring(i), table))
        table.fill(0)
    }
    return max
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val str = readLine()

    println(solve(str))
}
