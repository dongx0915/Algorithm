package BOJ2744

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    println(readLine().map { ch -> if(ch in 'A' .. 'Z') ch + 32 else ch - 32 }.toCharArray())
}
