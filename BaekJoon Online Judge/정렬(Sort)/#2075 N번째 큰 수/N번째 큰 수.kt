import java.util.Collections
import java.util.PriorityQueue

fun main(){
    val n = readln().toInt()
    val queue = PriorityQueue<Int>(Collections.reverseOrder())

    repeat(n){
        val input = readln().split(" ").map { it.toInt() }
        queue.addAll(input)
    }

    var result = 0
    repeat(n){
        result = queue.poll()
    }
    println(result)
}