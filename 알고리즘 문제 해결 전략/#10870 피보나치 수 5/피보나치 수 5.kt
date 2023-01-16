import java.util.*

fun fibo(n:Int): Int{
    if(n == 0) return 0
    if(n <= 2) return 1

    return fibo(n-1) + fibo(n-2)
}
fun main() = with(Scanner(System.`in`)){
    println(fibo(nextInt()))
}