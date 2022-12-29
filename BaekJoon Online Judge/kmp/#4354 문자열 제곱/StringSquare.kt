package main.kotlin.BOJ4354

import java.io.BufferedReader
import java.io.InputStreamReader

fun makeTable(p:String): Int{
    val table = Array(p.length){0}
    var j = 0

    for (i in 1 until p.length){
        while(j > 0 && p[i] != p[j]) j = table[j-1]

        if(p[i] == p[j]) table[i] = ++j
    }

    printTable(table)
    return table.last()
}

fun solve(str:String):Int{
    val last = makeTable(str)
    val remain = str.length % (str.length - last)
    val div = str.length / (str.length - last)

    return if(remain == 0) div else 1
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var str:String
    val sb = StringBuilder()

    while(true){
        str = readLine()
        if(str == ".") break

        sb.append(solve(str)).append("\n")
    }
    print(sb.toString())
}
