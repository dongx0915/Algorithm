import kotlin.math.min

lateinit var dp:Array<Int>

// 상향식 방법
// dp[i] = min(dp[i-1]+1, dp[i/3]+1, dp[i/2]+1)
fun solve(x:Int):Int {
    for (i in 2 until x + 1){
        // 아래 3가지의 경우 중 최솟값이 dp[i]에 들어가게 됨
        dp[i] = dp[i-1] + 1 // 1을 뺴는 경우
        if (i % 3 == 0)
            dp[i] = min(dp[i], dp[i/3] + 1)
        if(i % 2 ==0 )
            dp[i] = min(dp[i], dp[i/2] + 1)
    }
    return dp[x]
}

fun main(){
    val n = readln().toInt()
    dp = Array<Int>(n+1){ 0 }
    println(solve(n))
}
