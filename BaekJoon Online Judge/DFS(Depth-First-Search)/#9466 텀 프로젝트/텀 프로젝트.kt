import java.util.*
import kotlin.collections.HashSet

lateinit var team:HashSet<Int>
lateinit var nodes:Array<Int>
lateinit var visited:Array<Boolean>

fun dfs2(cur:Int, prev:HashSet<Int>): Int {
    if(team.contains(cur)) return -1
    if(prev.contains(cur)){
        team.add(cur)
        return cur
    }
    if(visited[cur]) return -1
    visited[cur] = true
    prev.add(cur)

    val cycle = dfs2(nodes[cur], prev)
    if(cycle == cur) return -1
    else if(cycle != -1) team.add(cur)

    return cycle
}

fun solve():Int {
    for (i in nodes.indices){
        if(team.contains(i)) continue
        dfs2(i, hashSetOf())
    }
    return nodes.size - team.size
}

fun main(){
    val t = readln().toInt()
    val sj = StringJoiner("\n")

    repeat(t){
        nodes = Array(readln().toInt()){0}
        visited = Array(nodes.size){false}
        team = hashSetOf()
        StringTokenizer(readln()).apply{
            repeat(countTokens()){
                nodes[it] = nextToken().toInt()-1
            }
        }
        sj.add("${solve()}")
    }
    println(sj)
}