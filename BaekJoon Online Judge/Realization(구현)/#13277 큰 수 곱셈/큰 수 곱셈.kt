fun main(){
    println(readln().split(" ").map { it.toBigInteger() }.run { this[0].multiply(this[1]) })
}