import java.io.BufferedReader
import java.io.InputStreamReader

fun getMax(array:ArrayList<Int>):Triple<Int,Int, Int> {
    var max = Int.MIN_VALUE
    var x=0; var y=0;

    for (i in 0 until 9){
        for (j in 0 until 9){
            if(max < array[i*9 + j]){
                max = array[i*9 + j]
                x = i; y = j;
            }
        }
    }
    return Triple(max,x+1,y+1)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val array = arrayListOf<Int>().apply {
        repeat(9){ this.addAll(readLine().split(" ").map { it.toInt() }) }
    }
    println(getMax(array).let { "${it.first}\n${it.second} ${it.third}" })
}