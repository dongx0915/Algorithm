fun main(){
    val (n, m) = readln().split(" ").map { it.toInt() }
    val array = Array(n){ it+1 }
    
    repeat(m){
        val (begin, end, mid) = readln().split(" ").map { it.toInt() }
        repeat(end-mid+1){
            for (i in end-1 downTo begin){
                array.swap(i,i-1)
            }
        }
    }
    array.forEach { print("$it ") }
    println()
}

fun Array<Int>.swap(n:Int, m:Int){
    val temp = this[n]
    this[n] = this[m]
    this[m] = temp
}