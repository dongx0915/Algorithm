fun main(){
    val n = readln()
    var temp = 0
    n.forEach {
        temp = (temp * 10 + (it-'0')) % 20000303
    }
    println(temp)
}