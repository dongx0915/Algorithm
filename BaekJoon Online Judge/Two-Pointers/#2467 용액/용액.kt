import kotlin.math.abs

fun solve(n:Int, num:List<Int>):Pair<Int, Int>{
    var i = 0
    var j = n-1
    var min = abs(num[i] + num[j])
    var minPair = Pair(num[i], num[j])

    while(i < j){
        var cur = abs(num[i] + num[j])
        // 최솟값이 같을 때도 체크해주면, 다른 경우까지 다 볼 수 있음
        if(min >= abs(cur)){
            min = abs(cur)
            minPair = Pair(num[i], num[j])
        }

        cur = abs(num[i] + num[j])
        if(cur >= abs(num[i+1] + num[j])) i++
        else j--
    }

    return minPair
}

fun main(){
    val n = readln().toInt()
    val num = readln().split(" ").map { it.toInt() }

    println(solve(n, num).run { "$first $second" })
}