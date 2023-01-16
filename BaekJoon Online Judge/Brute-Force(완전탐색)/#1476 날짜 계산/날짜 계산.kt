import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val result = readLine()
    var e = 1; var s = 1; var m = 1;

    for (i in 1..Int.MAX_VALUE){
        if("$e $s $m" == result){
            println(i)
            return@with
        }

        e = (i % 15) + 1
        s = (i % 28) + 1
        m = (i % 19) + 1
    }
}