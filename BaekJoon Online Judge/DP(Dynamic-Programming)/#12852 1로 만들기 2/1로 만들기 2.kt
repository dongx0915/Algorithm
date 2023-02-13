import java.util.*
import kotlin.math.min

lateinit var dp:Array<Int>
lateinit var prev:Array<Int>

// 상향식 방법
// dp[i] = min(dp[i-1]+1, dp[i/3]+1, dp[i/2]+1)
fun solve(x:Int):Int {
    for (i in 2 until x + 1){
        // 아래 3가지의 경우 중 최솟값이 dp[i]에 들어가게 됨
        dp[i] = dp[i-1] + 1 // 1을 뺴는 경우
        prev[i] = i-1       // i의 이전 값은 i-1이 됨

        if (i % 3 == 0){
            // i/3으로 갱신되는 경우
            // i의 이전 값은 i/3이 됨
            if(dp[i] > dp[i/3]+1) {
                dp[i] = dp[i/3]+1
                prev[i] = i/3
            }
        }
        if(i % 2 ==0 ){
            // i/2로 갱신되는 경우
            // i의 이전 값은 i/3이 됨
            if(dp[i] > dp[i/2]+1){
                dp[i] = dp[i/2]+1
                prev[i] = i/2
            }
        }
    }

    return dp[x]
}

fun main(){
    val n = readln().toInt()
    dp = Array(n+1){ 0 }
    prev = Array(n+1){ 0 }
    println(solve(n))

    val sj = StringJoiner(" ")
    var from = n
    while(from > 0){
        sj.add("$from")
        from = prev[from]
    }

    println(sj.toString())
}