fun main(){
    val (a,b,c) = readln().split(" ").map { it.toInt() }
    println("${b/a*3*c}")
}