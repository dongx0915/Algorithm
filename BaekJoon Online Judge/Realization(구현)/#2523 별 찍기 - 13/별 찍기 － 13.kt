fun main() {
    val n = readln().toInt()
    var cnt = 0
    for(i in 0 until 2*n-1){
        if(i < n) cnt++ else cnt--
        for(j in 0 until cnt) print("*")
        println()
    }
}
