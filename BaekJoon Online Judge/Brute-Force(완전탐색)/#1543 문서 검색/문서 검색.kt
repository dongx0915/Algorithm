import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val parent = readLine()
    val str = readLine()
    var cnt = 0
    var idx = 0

    while(idx + str.length <= parent.length){
        if (parent.substring(idx, idx + str.length) == str){
            cnt++
            idx += str.length-1
        }
        idx++
    }
    println(cnt)
}