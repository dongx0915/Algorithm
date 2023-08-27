import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().split(" ").map { it.toInt() }

    for (x in -999..999){
        for (y in -999..999){
            if(n[0]*x + n[1]*y == n[2] && n[3]*x + n[4]*y == n[5]) {
                println("$x $y")
                return
            }
        }
    }
}