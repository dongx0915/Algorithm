fun main(){
    val price = readln().toInt()
    val n = readln().toInt()
    var sum = 0

    repeat(n){
        sum += readln().split(" ")
            .map{ it.toInt() }
            .run { this[0] * this[1] }
    }
    println(if(price == sum) "Yes" else "No")
}