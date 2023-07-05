fun main() {
    val (h, m) = readln().split(" ").map { it.toInt() }
    val time = readln().toInt()

    println("${(h + ((time + m) / 60)) % 24} ${(m + (time % 60)) % 60}")
}