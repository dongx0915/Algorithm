import kotlin.math.max

lateinit var dp:Array<Int>

fun solve(list:List<Int>):Int{
    for (i in list.indices){
        // i = 먼저 선택되는 부분
        dp[i] = max(dp[i], list[i])
        for (j in i+1 until list.size){
            if(list[i] >= list[j]) continue // 다음 수가 작으면 패스
            dp[j] = max(dp[j], dp[i] + list[j])
        }
    }

    return dp.maxOrNull()!!
}

fun main(){
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    dp = Array(n){0}

    println(solve(list))
}