import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val stack = ArrayDeque<Int>()
    val result = StringJoiner("\n")

    repeat(n){
        val x = StringTokenizer(br.readLine())
        when(x.nextToken()){
            "1" -> stack.addLast(x.nextToken().toInt())
            "2" -> result.add("${if(stack.isEmpty()) -1 else stack.removeLast()}")
            "3" -> result.add("${stack.size}")
            "4" -> result.add("${if(stack.isEmpty()) 1 else 0}")
            "5" -> result.add("${if(stack.isEmpty()) -1 else stack.last()}")
        }
    }
    print(result)
}