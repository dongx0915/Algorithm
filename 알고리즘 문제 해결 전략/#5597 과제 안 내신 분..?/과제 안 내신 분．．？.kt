import java.util.*

fun main() = with(Scanner(System.`in`)){
    val list = arrayListOf<Int>().apply { for (i in 1 .. 30) add(i) }

    repeat(28){ list.remove(nextInt()) }
    list.forEach { println(it) }
}