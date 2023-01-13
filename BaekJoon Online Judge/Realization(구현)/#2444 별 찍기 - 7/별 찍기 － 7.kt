import java.util.*

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()

    for (i in 0 until n){
        for (j in i until n-1) print(" ")
        for (k in 0 until 2*i+1) print("*")
        println()
    }

    for (i in n-1 downTo  1){
        for (j in i until n) print(" ")
        for (k in 2*i - 1 downTo  1) print("*")
        println()
    }
}