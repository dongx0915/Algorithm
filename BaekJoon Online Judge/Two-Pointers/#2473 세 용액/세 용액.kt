import kotlin.math.abs

fun solve(n: Int, num: List<Long>): Triple<Long, Long, Long> {
    var min:Long = Long.MAX_VALUE
    var minLiquid = Triple(num[0], num[1], num[2])

    // 고정으로 하나를 골라 놓고, 나머지 값들에 대해 투 포인터 수행
    for (pick in 0 until n) {
        var s = pick + 1
        var e = n - 1

        while (s < e) {
            val cur:Long = num[pick] + num[s] + num[e]

            if (abs(min) > abs(cur)) {
                min = cur
                minLiquid = Triple(num[pick], num[s], num[e])
            }

            // 뒤로 갈수록 커지므로 음수일 땐 s를 당기고
            // 양수이면 e를 당김
            if (cur < 0) s++
            else e--
        }
    }

    return minLiquid
}

fun main() {
    val n = readln().toInt()
    val list = readln()
            .split(" ")
            .map { it.toLong() }
            .toList()
            .sorted()

    val result = solve(n, list)
    println("${result.first} ${result.second} ${result.third}")
}