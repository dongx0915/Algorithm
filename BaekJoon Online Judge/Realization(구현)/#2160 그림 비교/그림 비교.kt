import java.io.BufferedReader
import java.io.InputStreamReader

fun pictureDiff(list:ArrayList<StringBuilder>, n:Int):Pair<Int,Int>{
    var min = Int.MAX_VALUE
    var x = 0; var y = 0

    for (i in 0 until n){
        for (j in i+1 until n){
            val diff = diff(list[i], list[j])
            if(min > diff){
                min = diff; x = i; y = j
            }
        }
    }

    return Pair(x+1,y+1)
}

fun diff(p1:StringBuilder, p2:StringBuilder): Int{
    var cnt = 0
    for (i in 0 until 35) if(p1[i] != p2[i]) cnt++
    return cnt
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val pic = arrayListOf<StringBuilder>()

    repeat(n){
        pic.add(StringBuilder().apply {
            repeat(5){ append(readLine()) }
        })
    }

    println(pictureDiff(pic, n).let { "${it.first} ${it.second}" })
}