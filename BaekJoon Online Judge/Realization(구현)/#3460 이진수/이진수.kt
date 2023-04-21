import java.util.*

fun main() {
    val test = readln().toInt()

    repeat(test){
        val sb = StringBuilder()
        var n = readln().toInt()
        while(n > 0){
            sb.append(n%2)
            n /= 2
        }
        sb.forEachIndexed { index, c -> if(c == '1') print("$index ") }
        println()
    }
}