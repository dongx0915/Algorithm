fun main() {
    readln()
    var cnt = 0
    readln().onEach { if(it in setOf('a', 'e', 'i', 'o', 'u')) cnt++ }
    println(cnt)
}