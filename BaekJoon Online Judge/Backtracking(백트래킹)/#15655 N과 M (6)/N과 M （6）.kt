import java.util.*

lateinit var list: List<Int>
val sj = StringJoiner("\n")
fun solve(m:Int, s:String, prev:Int, select:Int){
    if(select == m){
        sj.add(s)
        return
    }

    for (i in list){
        if(prev < i)
            solve(m, "$s$i ", i, select + 1)
    }
}

fun main(){
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    list = readln().split(" ").map { it.toInt() }.sorted()

    solve(m, "", 0, 0)
    println(sj)
}