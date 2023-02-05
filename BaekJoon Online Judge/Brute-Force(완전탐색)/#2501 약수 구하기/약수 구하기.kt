fun solve(n:Int, k:Int){
    var cnt = 0
    for (i in 1..n){
        if(n % i == 0) {
            if(k == ++cnt) {
                println(i)
                return
            }
        }
    }
    println(0)
}

fun main(){
    val (n, k) = readln().split(" ").map { it.toInt() }
    solve(n,k)
}