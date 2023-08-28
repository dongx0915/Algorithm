import java.util.LinkedList
import java.util.Queue

fun Triple<Int, Int, Int>.addMinute(minute: Int = 1) = copy((first + ((second + minute) / 60)) % 24, (second + minute) % 60, third+ minute)
fun Triple<Int, Int, Int>.addHour(hour: Int = 1) = copy((first + hour) % 24, second, third+hour)

fun bfs(hour:Int, min: Int, nextHour: Int, nextMin: Int): Int{
    val q: Queue<Triple<Int, Int, Int>> = LinkedList()
    q.add(Triple(hour, min, 0))

    while (q.isNotEmpty()){
        val cur = q.poll()
        if(cur.first == nextHour && cur.second == nextMin) return cur.third

        if(cur.second != nextMin) q.add(cur.addMinute())
        else q.add(cur.addHour())
    }

    return -1
}

fun main() {
    val (hour, min) = readln().split(":").map { it.toInt() }
    val (nextHour, nextMin) = readln().split(":").map { it.toInt() }

    println(bfs(hour, min, nextHour, nextMin))
}