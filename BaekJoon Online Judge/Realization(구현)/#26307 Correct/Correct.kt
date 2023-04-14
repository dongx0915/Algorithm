fun main(){
    val (h,m) = readln().split(" ").map { it.toInt() }
    println((h-9) * 60 + m)
}