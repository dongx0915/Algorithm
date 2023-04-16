fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println(if((n*100) >= m) "Yes" else "No")
}