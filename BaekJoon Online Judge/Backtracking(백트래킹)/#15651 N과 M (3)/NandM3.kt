package BOJ15651

import java.lang.StringBuilder
import java.util.*
val sb = StringBuilder()

fun solve(n:Int, m:Int, s:String, select:Int){
    if(select == m){
        sb.append(s).append("\n")
        return
    }

    for (i in 1 .. n){
        solve(n,m, "$s$i ", select + 1)
    }
}

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    val m = nextInt()

    solve(n,m,"", 0)
    print(sb.toString())
}
