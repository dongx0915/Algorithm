import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()

    repeat(n){
        val str = readLine().split(",").map { it.toInt() }
        println(str[0]+ str[1])
    }
}