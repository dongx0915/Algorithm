fun main(){
    val n = readln().toInt()
    repeat(n){
        println(readln().split(" ").map { it.toInt() }.sum())
    }
}