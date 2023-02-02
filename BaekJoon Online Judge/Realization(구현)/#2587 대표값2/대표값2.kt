fun main(){
    arrayListOf<Int>().apply {
        repeat(5){ this.add(readln().toInt()) }
        sort()
        println(average().toInt())
        println(this[this.size/2])
    }
}