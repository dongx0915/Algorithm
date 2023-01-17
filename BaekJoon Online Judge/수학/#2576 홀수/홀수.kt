fun main(){
    var sum = 0
    var min = 10000
    val list = List(7){ readln().toInt() }
    for (i in list){
        if(i % 2 != 0){
            sum += i
            min = Math.min(min, i)
        }
    }

    if(sum == 0) println(-1)
    else println("$sum\n$min")
}