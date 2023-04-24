fun main(){
    while(true){
        val n = readln().toInt()
        if(n == 0) break
        println("${n*(n+1)/2}")
    }
}