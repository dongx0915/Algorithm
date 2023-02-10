import java.util.*

fun main(){
    val n = readln().toInt()
    val sj = StringJoiner("\n")
    for (i in 0 until  n)
        sj.add("*".repeat(i+1) + " ".repeat(2*(n-i-1)) + "*".repeat(i+1))

    for (i in n-2 downTo 0 )
        sj.add("*".repeat(i+1) + " ".repeat(2*(n-i-1)) + "*".repeat(i+1))

    println(sj.toString())
}