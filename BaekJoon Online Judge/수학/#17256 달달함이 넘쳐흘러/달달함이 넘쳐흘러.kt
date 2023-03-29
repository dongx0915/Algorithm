import kotlin.math.abs

fun main(){
    val (ax, ay, az) = readln().split(" ").map { it.toInt() }
    val (cx, cy, cz) = readln().split(" ").map { it.toInt() }
    println("${abs(az - cx)} ${if(ay >= cy) ay / cy else cy / ay} ${abs(cz - ax)}")
}