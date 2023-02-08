fun main(){
    val n = readln().toInt()
    for (i in 0 until n){
        for (j in 0 until i)
            print(" ")
        for (j in 2*(n-i-1) downTo 0)
            print("*")
        println()
    }
}