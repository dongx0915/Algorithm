import java.lang.Integer.max

lateinit var stairs:Array<Int>
lateinit var dp:Array<Array<Int>>

fun solve(prev:Int, now:Int, prevStairs:Int){
    if(now < 0) return
    if(prev + stairs[now] < dp[prevStairs][now]) return

    dp[prevStairs][now] = prev + stairs[now]

    if(prevStairs != 0) solve(dp[prevStairs][now], now-1, 0)
    solve(dp[prevStairs][now], now-2, 1)
}

fun main(){
    val n = readln().toInt()
    stairs = Array(n){0}
    dp = Array(n){ Array(n){0} }

    repeat(n){ stairs[it] = readln().toInt() }

    if(n == 1) {
        println(stairs.last())
        return
    }

    solve(0, n-1, 1)
    dp[1][n-1] = stairs[n-1]

    val max1 = max(dp[0][0], dp[0][1])
    val max2 = max(dp[1][0], dp[1][1])

    println(max(max1,max2))
}