package BOJ15649

import java.lang.StringBuilder
import java.util.*

lateinit var visited:Array<Boolean>
val sb = StringBuilder()

fun solve(n:Int, m:Int, s:String, select:Int){
    if(select == m){ // m개를 골랐으면 출력하고 리턴
        sb.append(s).append("\n")
        return
    }

    for (i in 1..n){
        if (!visited[i]){
            visited[i] = true
            solve(n, m,"$s$i ", select + 1)
            visited[i] = false
        }
    }
}

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    val m = nextInt()

    visited = Array(n+1){ false }
    solve(n,m,"", 0)

    print(sb.toString())
}
