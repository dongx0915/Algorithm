import java.util.LinkedList
import java.util.Queue

private val map = arrayListOf<StringBuilder>()
private val visit = Array(10){ Array(10){0} }

private val dx = arrayListOf(-1, 0, 1, 0)
private val dy = arrayListOf( 0,-1, 0, 1)

lateinit var lake: Pair<Int, Int>

fun Pair<Int, Int>.isOutRange() = first < 0 || first >= 10 || second < 0 || second >= 10

fun bfs(): Int {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    val cntQ: Queue<Int> = LinkedList()

    q.add(lake) // 호수에서 시작
    cntQ.add(0)

    while (q.isNotEmpty()){
        val cur = q.poll()
        val cnt = cntQ.poll()

        for (i in 0 until 4){
            val next = Pair(cur.first + dx[i], cur.second + dy[i])

            if(next.isOutRange()) continue

            val nextChar = map[next.first][next.second]
            val visitCnt = visit[next.first][next.second]

            if(nextChar == 'B') return cnt
            if(nextChar != '.') continue
            if(visitCnt <= cnt && visitCnt != 0) continue

            visit[next.first][next.second] = cnt + 1
            q.add(next)
            cntQ.add(cnt+1)
        }
    }

    return -1
}

fun main(){
    repeat(10){ i ->
        val input = StringBuilder(readln()).onEachIndexed { j, c ->
            if(c == 'L') lake = Pair(i, j)
        }
        map.add(input)
    }
    println(bfs())
}