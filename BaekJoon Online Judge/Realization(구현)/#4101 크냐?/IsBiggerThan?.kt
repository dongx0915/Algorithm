import java.util.*

fun main() = with(Scanner(System.`in`)){
    while(true){
        val n = nextInt()
        val m = nextInt()
        if(n == 0 && m == 0) break
        println(if(n > m) "Yes" else "No")
    }
}
