fun main(){
    val n = readln().toInt()
    repeat(n){
        readln().apply { println("${this.first()}${this.last()}") }
    }
}