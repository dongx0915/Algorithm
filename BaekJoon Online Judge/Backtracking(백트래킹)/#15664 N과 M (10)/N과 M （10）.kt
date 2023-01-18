import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

lateinit var list:List<Int>
val sj = StringJoiner("\n")
val set = hashSetOf<String>()

fun solve(n:Int, m:Int, s:String, select:Int, prev:Int){
    if(select == m && !set.contains(s)){
        set.add(s)
        sj.add(s)
        return
    }

    for (i in 0 until n){
        if(prev < i)
            solve(n, m, "$s${list[i]} ", select + 1, i)
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    list = readLine().split(" ").map { it.toInt() }.sorted()

    solve(n, m, "", 0, -1)
    println(sj)
}