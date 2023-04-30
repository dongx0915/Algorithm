fun main(){
    val (n,m,k) = readln().split(" ").map { it.toInt() }
    println("${k/m} ${k%m}")
}