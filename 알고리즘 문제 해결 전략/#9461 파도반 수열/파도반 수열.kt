import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val sb = StringBuilder()
    val seq = Array<Long>(101){1}
    for (i in 3..100){ seq[i] = seq[i-2] + seq[i-3] }

    val test = readLine().toInt()
    repeat(test){
        sb.append(seq[readLine().toInt()-1]).append("\n")
    }
    print(sb.toString())
}