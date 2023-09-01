import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

private val map: Array<Array<Boolean>> = Array(8){ Array(8){ false } }
private val dx = arrayOf(-2,-1, 1, 2, 2, 1,-1,-2)
private val dy = arrayOf(-1,-2,-2,-1, 1, 2, 2, 1)

data class Posit(val x:Int, val y:Int, val cnt: Int = 0){
    fun isOutRange() = x !in 0 until 8 || y !in 0 until 8

    override fun equals(other: Any?): Boolean {
        val other:Posit = (other as? Posit) ?: return false
        return other.x == this.x && other.y == this.y
    }
}

fun bfs(start: Posit, end: Posit): Int {
    val q: Queue<Posit> = LinkedList()
    q.add(start)
    map[start.x][start.y] = true

    while (q.isNotEmpty()){
        val cur = q.poll()
        if(cur.equals(end)) return cur.cnt

        for (i in 0 until 8){
            val next = Posit(cur.x + dx[i], cur.y + dy[i], cur.cnt + 1)
            if(next.isOutRange()) continue
            if(map[next.x][next.y]) continue

            q.add(next)
            map[next.x][next.y] = true
        }
    }

    return -1
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val start = StringTokenizer(br.readLine()).let {
        Posit(it.nextToken().toInt()-1, it.nextToken().toInt()-1)
    }
    val end = StringTokenizer(br.readLine()).let {
        Posit(it.nextToken().toInt()-1, it.nextToken().toInt()-1)
    }

    println(bfs(start, end))
}