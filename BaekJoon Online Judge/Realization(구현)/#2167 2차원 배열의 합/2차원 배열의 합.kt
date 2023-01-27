import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,m) = inputList()
    val array = Array(n){Array(m){0}}

    repeat(n){
        inputList().forEachIndexed { index, i ->
            array[it][index] = i
        }
    }

    val sj = StringJoiner("\n")
    val test = readLine().toInt()
    repeat(test) {
        var sum = 0
        val (x1, y1, x2, y2) = inputList(-1)
        for (i in x1 .. x2){
            for (j in y1 .. y2){
                sum += array[i][j]
            }
        }
        sj.add("$sum")
    }
    println(sj)
}


fun BufferedReader.inputList(sub:Int = 0) = readLine().split(" ").map { it.toInt() + sub }