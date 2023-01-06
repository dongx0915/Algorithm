import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashSet

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val st = StringTokenizer(readLine())
    val set = HashSet<String>()
    var same = 0

    repeat(3){
        st.nextToken().let {
            if(set.contains(it)) same = it.toInt()
            set.add(it)
        }
    }

    println(when(set.size){
        1 -> 10000 + same * 1000
        2 -> 1000 + same * 100
        3 -> set.maxOrNull()!!.toInt() * 100
        else -> 0 })
}