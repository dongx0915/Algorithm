import java.lang.StringBuilder
import java.util.LinkedList
import java.util.Queue

private val map = arrayListOf<StringBuilder>()
private val dx = arrayOf(-1,  0, 1, 0)
private val dy = arrayOf( 0, -1, 0, 1)

fun Pair<Int, Int>.isOutRange(n:Int, m: Int): Boolean {
    return first < 0 || first >= n || second < 0 || second >= m
}

fun bfs(x:Int, y: Int, n: Int, m: Int){
    val q:Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(x, y))

    while (q.isNotEmpty()){
        val cur = q.poll()
        map[cur.first][cur.second] = ' '

        for (i in 0 until 4) {
            val next = Pair(cur.first + dx[i], cur.second + dy[i])
            if(next.isOutRange(n, m)) continue

            if(map[next.first][next.second] == '#') {
                q.add(next)
            }
        }
    }
}

fun solve(n:Int, m:Int): Int {
    var cnt = 0
    for (i in 0 until n){
        for(j in 0 until m){
            if(map[i][j] == '#'){
                bfs(i, j, n, m)
                cnt++
            }
        }
    }

    return cnt
}

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    repeat(n){
        map.add(StringBuilder(readln()))
    }

    println(solve(n, m))
}