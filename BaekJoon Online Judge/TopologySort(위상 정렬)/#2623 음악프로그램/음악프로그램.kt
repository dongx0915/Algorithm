import java.util.*
import kotlin.collections.ArrayList

lateinit var ins:Array<Int>
lateinit var node:Array<Node>

class Node(val adj:ArrayList<Int>)

fun topologySort(n:Int):String {
    val sj = StringJoiner("\n")
    val queue = LinkedList<Int>()
    for (i in 1..n) if(ins[i]==0) queue.add(i)

    for (i in 1 .. n){
        if(queue.isEmpty()) return "0"

        val cur = queue.poll()
        sj.add("$cur")

        node[cur].adj.forEach {
            if(--ins[it] == 0) queue.add(it)
        }
    }

    return sj.toString()
}

fun main(){
    val (n, pd) = readln().split(" ").map { it.toInt() }

    node = Array(n+1){ Node(arrayListOf()) }
    ins = Array(n+1){ 0 }

    repeat(pd){
        val list = readln().split(" ").map { it.toInt() }

        for (i in 1 until list[0]){
            node[list[i]].adj.add(list[i+1])
            ins[list[i+1]]++
        }
    }

    println(topologySort(n))
}