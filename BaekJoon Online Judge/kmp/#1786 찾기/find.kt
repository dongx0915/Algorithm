package main.kotlin.BOJ1786

import java.io.BufferedReader
import java.io.InputStreamReader


fun makeTable(p:String):Array<Int> {
    val table = Array(p.length){ 0 }
    var idx = 0

    for (i in 1 until p.length){
        while(idx > 0 && p[i] != p[idx]) idx = table[idx-1]

        if(p[i] == p[idx]) {
            table[i] = ++idx
        }
    }

    return table
}

fun kmp(parent:String, pattern:String){
    val table = makeTable(pattern)
    var idx = 0; var cnt = 0
    val sb = StringBuilder()

    for(i in parent.indices){
        while(idx > 0 && parent[i] != pattern[idx]) idx = table[idx-1]

        if(parent[i] == pattern[idx]){
            if(idx == pattern.length-1){
                idx = table[idx]
                cnt++
                sb.append("${i-pattern.length+2} ")
            }
            else
                idx++
        }
    }
    
    println(cnt)
    println(sb.toString())
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val parent = readLine()
    val pattern = readLine()

    kmp(parent, pattern)
}
