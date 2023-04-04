fun main(){
    val a = readln().toInt()
    val b = readln().toInt()

    println( if (a < b) -1 else if(a > b) 1 else 0 )
}