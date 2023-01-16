import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val hashSet = readLine().split(" ").map { it.toInt() }.toHashSet()

    val m = readLine().toInt()
    val num = readLine().split(" ").map { it.toInt() }

    val sj = StringJoiner(" ")
    num.forEach { sj.add("${if(hashSet.contains(it)) 1 else 0}") }

    println(sj.toString())
}