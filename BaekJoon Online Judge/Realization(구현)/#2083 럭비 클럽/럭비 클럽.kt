fun main() {
    while (true){
        val input = readln()
        if(input == "# 0 0") return

        input.split(" ").apply {
            println("${this[0]} ${if(this[1].toInt() > 17 || this[2].toInt() >= 80) "Senior" else "Junior"}")
        }
    }
}