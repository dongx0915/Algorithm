package main.kotlin.BOJ1992

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

val map: ArrayList<String> = arrayListOf()
var n:Int = 0

fun compression(x:Int, y:Int, size:Int):String{
    if(x >= n || y >= n) return ""

    var prev = map[x][y]

    for (i in x until x + size){
        for (j in y until y + size){
            if(prev != map[i][j]){
                // 재귀 호출 들어가기
                // 재귀 들어갈 때 괄호를 열고, 나올 때 닫음
                return StringBuilder("(").apply {
                    val s = size / 2
                    append(compression(x = x,   y = y,   size = s)) // 왼쪽 위
                    append(compression(x = x,   y = y+s, size = s)) // 오른쪽 위
                    append(compression(x = x+s, y = y,   size = s)) // 왼쪽 아래
                    append(compression(x = x+s, y = y+s, size = s)) // 오른쪽 아래
                    append(")")
                }.toString()
            }
            prev = map[i][j]
        }
    }

    return "$prev"
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val st = StringTokenizer(readLine())
    n = st.nextToken().toInt()

    repeat(n){ map.add(readLine()) }

    println(compression(0,0, n))
}
