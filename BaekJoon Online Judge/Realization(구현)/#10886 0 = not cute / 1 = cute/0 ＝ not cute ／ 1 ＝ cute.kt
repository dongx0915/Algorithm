fun main(){
    val n = readln().toInt()
    var cnt = 0
    repeat(n){
        readln().apply {
            if(equals("0")) cnt--
            else cnt++
        }
    }
    println(if(cnt > 0) "Junhee is cute!" else "Junhee is not cute!")
}