import java.util.LinkedList
import java.util.Queue

fun bfs(a: Int, k: Int, visit: Array<Boolean>): Int {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(a, 0))

    while (q.isNotEmpty()){
        val cur = q.poll()
        if(cur.first == k) return cur.second

        val plus = cur.first + 1
        val multi = cur.first * 2

        if(plus <= k && !visit[plus]) {
            q.add(Pair(plus, cur.second + 1))
            visit[plus] = true
        }
        if(multi <= k && !visit[multi]) {
            q.add(Pair(multi, cur.second + 1))
            visit[multi] = true
        }
    }

    return -1
}

fun main(){
    val (a, k) = readln().split(" ").map { it.toInt() }
    val visit = Array<Boolean>(k+1){false}
    println(bfs(a, k, visit))
}