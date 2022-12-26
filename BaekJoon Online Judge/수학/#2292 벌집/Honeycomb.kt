package main.kotlin.BOJ2292

import java.util.*

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    var cnt = 0
    var i = 1

    while (true){
        if(n <= i){
            println("${cnt+1}")
            break
        }
        i += (++cnt * 6)
    }
}
