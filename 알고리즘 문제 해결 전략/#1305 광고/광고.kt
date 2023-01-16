import java.io.BufferedReader
import java.io.InputStreamReader

fun makeTable(p:String): Int {
    val table = Array<Int>(p.length){0}
    var j = 0

    for (i in 1 until p.length){
        while(j > 0 && p[i] != p[j]) j = table[j-1]
        if(p[i] == p[j]) table[i] = ++j
    }
    return table.last()
}


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val last = makeTable(readLine())

    println(n - last)
}