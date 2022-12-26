package main.kotlin.BOJ15654

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

val num = arrayListOf<Int>()
val sb = StringBuilder()
val select = arrayListOf<Int>()
val visit = Array<Boolean>(10000 + 1){false}

fun solve(n:Int, m:Int, select:ArrayList<Int>){
    if(select.size == m){
        select.forEach { sb.append(it).append(" ") }
        sb.append("\n")
        return
    }

    for(i in num){
        if(visit[i]) continue
        visit[i] = true
        select.add(i)

        solve(n, m, select )

        visit[i] = false
        select.remove(i)
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(readLine())

    repeat(n){ num.add(st.nextToken().toInt()) }
    num.sort()

    solve(n,m, select)
    print(sb.toString())
}
