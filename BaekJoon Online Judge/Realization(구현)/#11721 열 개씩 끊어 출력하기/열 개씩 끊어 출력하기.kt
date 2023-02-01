fun main(){
    val str = readln()
    for (i in str.indices step 10){
        println(
            if(i+10 >= str.length) str.substring(i)
            else str.substring(i, i+10)
        )
    }
}