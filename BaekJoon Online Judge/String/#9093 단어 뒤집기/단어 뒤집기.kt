import java.util.StringJoiner

fun main(){
    val n = readln().toInt()
    var sj = StringJoiner(" ")
    repeat(n){
        val list = readln().split(" ")
        list.forEach { sj.add(it.reversed()) }
        println(sj.toString())
        sj = StringJoiner(" ")
    }
}