import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    println(readLine().let { if(it == it.reversed()) 1 else 0})
}