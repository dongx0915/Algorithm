package BOJ24445

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

lateinit var adj:Array<ArrayList<Int>>

fun bfs(n:Int, m:Int, r:Int):String{
    val sb = StringBuilder()
    val queue:Queue<Int> = LinkedList()
    val seq = Array(n+1){0}
    var cnt = 1

    queue.add(r)
    seq[r] = cnt

    while(!queue.isEmpty()){
        val cur = queue.poll()

        for (i in adj[cur]){
            if(seq[i] == 0){ // cur->i가 연결된 경우, i를 방문하지 않은 경우
                queue.add(i)
                seq[i] = ++cnt
            }
        }
    }

    for (i in 1 .. n) sb.append("${seq[i]}\n")

    return sb.toString()
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine(), " ")

    val n = st.nextToken().toInt() // 정점의 수
    val m = st.nextToken().toInt() // 간선의 수
    val r = st.nextToken().toInt() // 시작 정점

    adj = Array(n+1){ ArrayList() }

    for (i in 0 until m){
        st = StringTokenizer(readLine(), " ")
        val n1 = st.nextToken().toInt()
        val n2 = st.nextToken().toInt()
        adj[n1].add(n2)
        adj[n2].add(n1)
    }

    for (i in adj) i.sortDescending()

    print(bfs(n,m,r))
}
