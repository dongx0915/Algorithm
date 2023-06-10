import java.util.*
import kotlin.math.max

fun topologySort(
    n:Int,
    last:Int,
    adj:Array<ArrayList<Int>>,
    time:Array<Int>,
    dis:Array<Int>
): Int{
    val queue = LinkedList<Int>()
    val dp = Array(n){0}

    dis.forEachIndexed { idx, i ->
        if(i == 0){
            if(idx == last) return time[idx]

            queue.add(idx)
            dp[idx] = time[idx]
        }
    }

    repeat(n){
        val cur = queue.poll()
        if(cur == last) return dp[cur]

        adj[cur].forEach { next ->
            dp[next] = max(dp[next], time[next] + dp[cur])
            if(--dis[next] == 0) {
                queue.add(next)
            }
        }
    }

    return 0
}

fun main(){
    val test = readln().toInt()

    repeat(test){
        // n: 건물 개수
        // k: 건설 순서 규칙
        val (n, k) = readln().split(" ").map { it.toInt() }

        val adj = Array<ArrayList<Int>>(n){ arrayListOf() } // 인접 리스트
        val time = Array(n){0} // 건설 시간
        val dis = Array(n){0}

        readln().split(" ").forEachIndexed { i, c ->
            time[i] = c.toInt()
        }

        repeat(k){
            val(n1, n2) = readln().split(" ").map { it.toInt()-1 }
            adj[n1].add(n2)
            dis[n2]++
        }

        // last: 목표 건물
        val last = readln().toInt()-1
        println(topologySort(n, last, adj, time, dis))
    }
}