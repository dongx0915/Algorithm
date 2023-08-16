fun gcd(n1: Long, n2: Long): Long {
    if(n2 == 0L) return n1
    return gcd(n2, n1 % n2)
}

fun main() {
    val (n1, n2) = readln().split(" ").map { it.toLong() }
    println(n1 * n2 / gcd(n1, n2))
}