import kotlin.math.max

lateinit var dp:Array<Int>

fun solve(list:List<Int>):Int{
    for (i in list.indices){
        // i = 먼저 선택되는 부분
        for (j in i+1 until list.size){
            if(list[j] < list[i])
                dp[j] = max(dp[i] + 1, dp[j])
        }
    }

    return dp.maxOrNull()!!
}

fun main(){
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    dp = Array(n){1}

    println(solve(list))
}