import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    var max = Int.MIN_VALUE; var x = 0; var y = 0;
    repeat(81){
        nextToken()
        val num = nval.toInt()
        if(max < num){ max = num; x = it / 9; y = it % 9; }
    }
    println("$max\n${x+1} ${y+1}")
}