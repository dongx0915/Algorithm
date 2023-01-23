import kotlin.math.abs
fun main(){ readln().split(" ").map { it.toLong() }.apply { println(abs(this[0]-this[1])) } }