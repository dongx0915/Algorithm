import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

class Node(
    var weight  :Int,
    val adj: ArrayList<Int> = arrayListOf()
)

lateinit var nodes:Array<Node>
var max = 0

fun dfs(p:Node):Int {
    // 리프 노드인 경우 weight 리턴
    if(p.adj.isEmpty()) return p.weight

    val weights = PriorityQueue<Int>(Collections.reverseOrder())
    p.adj.forEach {
        weights.add(dfs(nodes[it]))
    }

    val w1 = weights.poll()?:0
    val w2 = weights.poll()?:0

    // 자식 노드들의 가중치 중 상위 2개를 더한 값과 max를 비교
    max = max(max ,w1+w2)
    
    // 자신의 weight와 자식 노드들 중에서 최대 가중치의 합을 리턴
    return p.weight + w1
}

fun main(){
    val n = readln().toInt()
    nodes = Array(n+1){ Node(0)}

    repeat(n-1){
        val (n1, n2, w) = readln().split(" ").map { it.toInt() }
        nodes[n2].weight = w
        nodes[n1].adj.add(n2)
    }

    dfs(nodes[1])
    println(max)
}