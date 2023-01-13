import java.io.BufferedReader
import java.io.InputStreamReader

fun hiddenNumber(str:String): Long{
    var sum:Long = 0
    var hidden = ""
    str.forEach {
        if(it.isDigit()){
            hidden += it
        }else {
            if(hidden.length > 6) hidden = ""
            if(hidden != ""){
                sum += hidden.toLong()
                hidden = ""
            }
        }
    }
    if(hidden != "" && hidden.length <= 6) sum += hidden.toLong()
    return sum
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val str = readLine()

    println(hiddenNumber(str))
}