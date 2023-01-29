import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toLong() }

    val array = Array<Long>(n+1){0}
    var sum:Long = 0

    list.forEachIndexed { index, i -> array[index + 1] = array[index] + i }
    list.forEachIndexed { index, i ->
        sum += i * (array[n] - array[index+1])
    }

    println(sum)
}