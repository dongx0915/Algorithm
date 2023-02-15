import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.text.StringBuilder

val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf( 0,-1, 0, 1)
val map = Array(1001){ Array(1001){ 0 } }
val zeroGroup = HashMap<Int, Int>()

fun Pair<Int,Int>.isInRange(n:Int, m:Int)
    = this.run { !(first < 0 || first >= n || second < 0 || second >= m) }

fun bfs(n:Int, m:Int, start:Pair<Int, Int>, group:Int) {
    val q = LinkedList<Pair<Int,Int>>()
    var cnt = 0

    q.add(start)
    map[start.first][start.second] = group

    while(!q.isEmpty()){
        val cur = q.poll()
        cnt++

        for (i in 0 until 4){
            val next = Pair(cur.first + dx[i], cur.second + dy[i])
            if(!next.isInRange(n,m)) continue
            if(map[next.first][next.second] != 0) continue
            map[next.first][next.second] = group

            q.add(next)
        }
    }

    zeroGroup[group] = cnt
}

fun groupCheck(n:Int, m:Int) {
    var group = 2 // 0,1은 입력으로 들어오므로 2부터 시작
    
    for (i in 0 until n){
        for (j in 0 until m){
            if(map[i][j] != 0) continue
            bfs(n,m,Pair(i,j), group++)
        }
    }
}

fun solve(n: Int, m:Int): String{
    val sj = StringJoiner("\n")

    for (i in 0 until n){
        val sb = StringBuilder()
        for (j in 0 until m){
            if(map[i][j] != 1){
                sb.append(0)
                continue
            }

            val nextSet = HashSet<Int>() // 그룹 중복 카운트 방지를 위한 Set
            var sum = 1
            repeat(4) {
                Pair(i + dx[it], j + dy[it]).apply {
                    // 범위 내에 있고, 그룹 번호인 경우
                    if (isInRange(n, m) && map[first][second] > 1)
                        nextSet.add(map[first][second])
                }
            }
            
            nextSet.forEach { sum += zeroGroup[it]!! }
            sb.append(sum % 10)
        }
        sj.add(sb)
    }

    return sj.toString()
}

fun main(){
    val (n, m) = readln().split(" ").map { it.toInt() }

    repeat(n){
        val input = readln()
        input.forEachIndexed { index, c ->
            map[it][index] = c.toInt() - 48
        }
    }

    groupCheck(n, m)
    println(solve(n,m))
}