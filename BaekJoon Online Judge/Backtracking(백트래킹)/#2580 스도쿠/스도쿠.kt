import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.exitProcess

fun checkOverlap(map:Array<Array<Int>>, x:Int, y:Int):Boolean {
    for (i in 0 until 9){
        if(map[x][i] == map[x][y]) if(i != y) return false
        if(map[i][y] == map[x][y]) if(i != x) return false
    }

    val startX = getPosit(x)
    val startY = getPosit(y)

    for (i in startX until  startX + 3){
        for (j in startY until startY + 3){
            if(i == x && j == y) continue
            if(map[i][j] == map[x][y]) return false
        }
    }

    return true
}

fun getPosit(p:Int):Int {
    return when(p){
        in 0 until 3 -> 0
        in 3 until 6 -> 3
        in 6 until 9 -> 6
        else -> -1
    }
}

fun allCheck(map:Array<Array<Int>>):Boolean{
    for (i in 0 until 9){
        for (j in 0 until 9){
            if(!checkOverlap(map, i,j)) return false
        }
    }
    return true
}

fun solve(map:Array<Array<Int>>, zero:ArrayList<Pair<Int,Int>>, now:Int){
    if(zero.size == now){
        if(allCheck(map)){
            map.print()
            exitProcess(0)
        }
        else return
    }

    val cur = zero[now]
    for (i in 1 .. 9){
        map[cur.first][cur.second] = i

        val overlap = checkOverlap(map, cur.first, cur.second)
        if(overlap){ // 중복이 안되었으면
            solve(map, zero, now+1)
        }
    }
    map[cur.first][cur.second] = 0
}

fun main(){
    val map = Array(9){Array(9){ 0 }}
    val zero = arrayListOf<Pair<Int,Int>>()

    repeat(9){
        readln().split(" ").map { it.toInt() }.forEachIndexed { idx, i ->
            map[it][idx] = i
            if(i == 0) zero.add(Pair(it, idx))
        }
    }

    solve(map, zero, 0)
}

fun Array<Array<Int>>.print(){
    this.forEach {
        it.forEach { print("$it ") }
        println()
    }
}