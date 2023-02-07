import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun dp(n:Int, t:Array<ArrayList<Int>>): Int{
    val dp = Array(n){ Array(n){0} }
    dp[0][0] = t[0][0]

    for (i in 0 until n-1){
        for (j in 0 .. i){
            dp[i+1][j] = max(dp[i+1][j], dp[i][j] + t[i+1][j])
            dp[i+1][j+1] = max(dp[i+1][j+1], dp[i][j] + t[i+1][j+1])
        }
    }

    return dp.last().maxOrNull()!!
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val t = Array<ArrayList<Int>>(n){ arrayListOf() }

    repeat(n){ idx->
        t[idx].addAll(readLine().split(" ").map { it.toInt() })
    }

    println(dp(n, t))
}