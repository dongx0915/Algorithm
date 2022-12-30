package main.kotlin.BOJ15652

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

val sb = StringBuilder()

fun solve(n:Int, m:Int, s:String, select:Int, prev:Int){
    if(select == m){
        sb.append(s).append("\n")
        return
    }

    for (i in 1..n){
        if(prev <= i)
            solve(n, m, "$s$i ", select + 1, i)
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val st = StringTokenizer(readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    solve(n, m, "", 0, 0)
    print(sb.toString())
}
