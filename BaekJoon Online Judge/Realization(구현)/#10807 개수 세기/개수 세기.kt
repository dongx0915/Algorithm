fun main(){
    val array = Array(202){0}
    readln().toInt()
    readln().split(" ").map { it.toInt() }.forEach { array[it+100]++ }

    println(array[readln().toInt()+100])
}